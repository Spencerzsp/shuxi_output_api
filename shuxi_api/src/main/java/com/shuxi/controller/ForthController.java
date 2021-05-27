package com.shuxi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shuxi.entity.TdmTopCityFormDf;
import com.shuxi.entity.TdmTopVoyageFormDf;
import com.shuxi.service.ITdmTopVoyageFormDfService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: Yu Hao
 * DateTime: 2021-05-26 19:36
 */
@RestController
public class ForthController {


    @Autowired
    private ITdmTopVoyageFormDfService tdmTopVoyageFormDfService;
    //2020年十佳航线
    //tdm_top_voyage_form_df
    @RequestMapping("/topVoyage2020")
    public String topVoyage2020(){
        try {
            QueryWrapper<TdmTopVoyageFormDf> queryWrapper = new QueryWrapper<>();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            String year = simpleDateFormat.format(new Date());
            queryWrapper.eq("count_year",Integer.parseInt(year)-1);
            List<TdmTopVoyageFormDf> tdmTopVoyageFormDfs = tdmTopVoyageFormDfService.list(queryWrapper);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("航线");
            jsonArray1.put("货量");
            jsonArray.put(jsonArray1);
            for (TdmTopVoyageFormDf tdmTopVoyageFormDf : tdmTopVoyageFormDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmTopVoyageFormDf.getDprtPt()+"-"+tdmTopVoyageFormDf.getArrPt());
                jsonArray2.put(tdmTopVoyageFormDf.getCrgDdwghtTns());
                jsonArray.put(jsonArray2);
            }
            jsonObject.put("content",jsonArray);
            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("success",false);
                jsonObject.put("message","数据获取失败");
            } catch (JSONException jsonException) {

            }
            return jsonObject.toString();
        }
    }


    //2021年十佳航线
    //tdm_top_voyage_form_df
    @RequestMapping("/topVoyage2021")
    public String topVoyage2021(){
        try {
            QueryWrapper<TdmTopVoyageFormDf> queryWrapper = new QueryWrapper<>();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            String year = simpleDateFormat.format(new Date());
            queryWrapper.eq("count_year",Integer.parseInt(year));
            List<TdmTopVoyageFormDf> tdmTopVoyageFormDfs = tdmTopVoyageFormDfService.list(queryWrapper);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("航线");
            jsonArray1.put("货量");
            jsonArray.put(jsonArray1);
            for (TdmTopVoyageFormDf tdmTopVoyageFormDf : tdmTopVoyageFormDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmTopVoyageFormDf.getDprtPt()+"-"+tdmTopVoyageFormDf.getArrPt());
                jsonArray2.put(tdmTopVoyageFormDf.getCrgDdwghtTns());
                jsonArray.put(jsonArray2);
            }
            jsonObject.put("content",jsonArray);
            return jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("success",false);
                jsonObject.put("message","数据获取失败");
            } catch (JSONException jsonException) {

            }
            return jsonObject.toString();
        }
    }


}
