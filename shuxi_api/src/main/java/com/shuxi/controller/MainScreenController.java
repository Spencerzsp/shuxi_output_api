package com.shuxi.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shuxi.entity.TdmShipTonnageDistributionDf;
import com.shuxi.entity.TdmXjMainLineFreightRateDf;
import com.shuxi.service.ITdmShipTonnageDistributionDfService;
import com.shuxi.service.ITdmXjMainLineFreightRateDfService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

/**
 * @author ZhangQi
 * @version 1.0.0
 * @ClassName MainScreenController.java
 * @Description TODO
 * @createTime 2021年05月21日 17:49:00
 */
@RestController
public class MainScreenController {
    @Autowired
    private ITdmShipTonnageDistributionDfService tdmShipTonnageDistributionDfService;
    @Autowired
    private ITdmXjMainLineFreightRateDfService tdmXjMainLineFreightRateDfService;
    //西江流域（近一月）船舶吨位分布图
    @GetMapping("/valleyShipTonDistributing")
    public String valleyShipTonDistributing() {
        try {
            List<TdmShipTonnageDistributionDf> tdmShipTonnageDistributionDfs = tdmShipTonnageDistributionDfService.list();
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("label");
            jsonArray1.put("value");
            jsonArray1.put("radius");
            jsonArray.put(jsonArray1);
            for (TdmShipTonnageDistributionDf tdmShipTonnageDistributionDf : tdmShipTonnageDistributionDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmShipTonnageDistributionDf.getShipTonnage());
                jsonArray2.put(1);
                jsonArray2.put(Double.parseDouble(tdmShipTonnageDistributionDf.getProportion()));
                jsonArray.put(jsonArray2);
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            jsonObject.put("content",jsonArray);
            return jsonObject.toString();
        } catch (Exception e) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("success",false);
                jsonObject.put("message","获取数据失败");
            } catch (JSONException jsonException) {

            }
            return jsonObject.toString();
        }
    }
    //运力周指数(流域)
    @RequestMapping("/capacityWeekIndexByValley")
    public String capacityWeekIndexByValley(@RequestParam String valley){
        QueryWrapper<TdmXjMainLineFreightRateDf> queryWrapper = new QueryWrapper<TdmXjMainLineFreightRateDf>().eq("target", "流域").eq("targe_name",valley);
        List<TdmXjMainLineFreightRateDf> tdmXjMainLineFreightRateDfs = tdmXjMainLineFreightRateDfService.list(queryWrapper);
        tdmXjMainLineFreightRateDfs.sort(new Comparator<TdmXjMainLineFreightRateDf>() {
            @Override
            public int compare(TdmXjMainLineFreightRateDf o1, TdmXjMainLineFreightRateDf o2) {
                return o1.getMonthDate().compareTo(o2.getMonthDate());
            }
        });
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("流域");
            jsonArray1.put("年月");
            jsonArray1.put("上行指数");
            jsonArray1.put("下行指数");
            jsonArray.put(jsonArray1);
            for (TdmXjMainLineFreightRateDf tdmXjMainLineFreightRateDf : tdmXjMainLineFreightRateDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmXjMainLineFreightRateDf.getTargetName());
                jsonArray2.put(tdmXjMainLineFreightRateDf.getMonthDate());
                jsonArray2.put(Double.parseDouble(tdmXjMainLineFreightRateDf.getUpRate()));
                jsonArray2.put(Double.parseDouble(tdmXjMainLineFreightRateDf.getDownRate()));
                jsonArray.put(jsonArray2);
            }
            jsonObject.put("content",jsonArray);
            return jsonObject.toString();
        } catch (Exception e) {
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
