package com.shuxi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shuxi.entity.TdmTopCityFormDf;
import com.shuxi.entity.TdmTopVoyageFormDf;
import com.shuxi.entity.TdmVoyageInfo;
import com.shuxi.service.ITdmTopVoyageFormDfService;
import com.shuxi.service.ITdmVoyageInfoService;
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
                jsonArray2.put(Double.parseDouble(tdmTopVoyageFormDf.getCrgDdwghtTns()));
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
                jsonArray2.put(Double.parseDouble(tdmTopVoyageFormDf.getCrgDdwghtTns()));
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

    /*
    *
    * {
    "success": true,
    "content": {
        "unit": "万吨",
        "label": "北斗船舶运力",
        "value": "9936731.850000001"
    }
   }
    *
    * */
    @Autowired
    private ITdmVoyageInfoService tdmVoyageInfoService;
    //tdm_voyage_info
    //航线总数
    @RequestMapping("/totalVoyageNumber")
    public String totalVoyageNumber(){
        try {
            QueryWrapper<TdmVoyageInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("target","总数");
            TdmVoyageInfo tdmVoyageInfo = tdmVoyageInfoService.getOne(queryWrapper);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("unit","条");
            jsonObject1.put("label","航线总数");
            jsonObject1.put("value",tdmVoyageInfo.getTargetValue());
            jsonObject.put("content",jsonObject1);
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


    //今年新增航线数
    @RequestMapping("/newVoyageThisYear")
    public String newVoyageThisYear(){
        try {
            QueryWrapper<TdmVoyageInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("target","今年新增航线数");
            TdmVoyageInfo tdmVoyageInfo = tdmVoyageInfoService.getOne(queryWrapper);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("unit","条");
            jsonObject1.put("label","今年新增航线数");
            jsonObject1.put("value",tdmVoyageInfo.getTargetValue());
            jsonObject.put("content",jsonObject1);
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


    //广西发航线数
    @RequestMapping("/gxVoyage")
    public String gxVoyage(){
        try {
            QueryWrapper<TdmVoyageInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("target","广西");
            TdmVoyageInfo tdmVoyageInfo = tdmVoyageInfoService.getOne(queryWrapper);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("unit","条");
            jsonObject1.put("label","广西发航线数");
            jsonObject1.put("value",tdmVoyageInfo.getTargetValue());
            jsonObject.put("content",jsonObject1);
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



    //广东发航线数
    @RequestMapping("/gdVoyage")
    public String gdVoyage(){
        try {
            QueryWrapper<TdmVoyageInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("target","广东");
            TdmVoyageInfo tdmVoyageInfo = tdmVoyageInfoService.getOne(queryWrapper);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("unit","条");
            jsonObject1.put("label","广东发航线数");
            jsonObject1.put("value",tdmVoyageInfo.getTargetValue());
            jsonObject.put("content",jsonObject1);
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


    //运力、重量（货量）、占比（货量占总货量的占比）、同比（今年同期货量和去年同期的对比）


}
