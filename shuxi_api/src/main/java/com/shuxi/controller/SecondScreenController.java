package com.shuxi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shuxi.dto.TdmThisYearEachShiplockForecastDfDTO;
import com.shuxi.entity.TdmEachShiplockLockageDf;
import com.shuxi.entity.TdmRecentYearLockageYearIncreaseDf;
import com.shuxi.entity.TdmShipGateWayCountDf;
import com.shuxi.entity.TdmThisYearEachMonthLockageDf;
import com.shuxi.service.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SecondScreenController {
    @Autowired
    private ITdmEachShiplockLockageDfService tdmEachShiplockLockageDfService;
    @Autowired
    private ITdmThisYearEachMonthLockageDfService tdmThisYearEachMonthLockageDfService;
    @Autowired
    private ITdmRecentYearLockageYearIncreaseDfService tdmRecentYearLockageYearIncreaseDfService;
    @Autowired
    private ITdmThisYearEachShiplockForecastDfService tdmThisYearEachShiplockForecastDfService;
    //本年船闸过闸数据
    @RequestMapping("/thisYearShipLockageByShipLock")
    public String thisYearShipLockageByShipLock(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String year = simpleDateFormat.format(new Date());
        QueryWrapper<TdmEachShiplockLockageDf> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("fz_year",year);
        try {
            List<TdmEachShiplockLockageDf> tdmEachShiplockLockageDfs = tdmEachShiplockLockageDfService.list(queryWrapper);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("船闸");
            jsonArray1.put("艘次");
            jsonArray.put(jsonArray1);
            for (TdmEachShiplockLockageDf tdmEachShiplockLockageDf : tdmEachShiplockLockageDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmEachShiplockLockageDf.getSnid());
                jsonArray2.put(tdmEachShiplockLockageDf.getCzCount());
                jsonArray.put(jsonArray2);
            }
            jsonObject.put("content",jsonArray);
            return jsonObject.toString();
        } catch (JSONException e) {
            // e.printStackTrace();
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("success",false);
                jsonObject.put("message","数据获取失败");
            } catch (JSONException jsonException) {

            }
            return jsonObject.toString();
        }
    }

    //本年船闸过闸数据（按月统计）
    @RequestMapping("/thisYearShipLockageByMonth")
    public String thisYearShipLockageByMonth(@RequestParam String shipLock){
        QueryWrapper<TdmThisYearEachMonthLockageDf> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("snid",shipLock);
        try {
            List<TdmThisYearEachMonthLockageDf> tdmThisYearEachMonthLockageDfs = tdmThisYearEachMonthLockageDfService.list(queryWrapper);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            String year = simpleDateFormat.format(new Date());
            jsonArray1.put("月份");
            jsonArray1.put("总吨");
            jsonArray1.put("核载");
            jsonArray1.put("实载");
            jsonArray1.put("艘次");
            jsonArray.put(jsonArray1);
            for (TdmThisYearEachMonthLockageDf tdmThisYearEachMonthLockageDf : tdmThisYearEachMonthLockageDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(year+"/"+tdmThisYearEachMonthLockageDf.getFzMonth());
                jsonArray2.put(tdmThisYearEachMonthLockageDf.getTotTon());
                jsonArray2.put(tdmThisYearEachMonthLockageDf.getNclsCrryTns());
                jsonArray2.put(tdmThisYearEachMonthLockageDf.getCrgDdwghtTns());
                jsonArray2.put(tdmThisYearEachMonthLockageDf.getCzCount());
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

    //西江流域历年整年过闸数据同比变化
    @RequestMapping("/recentYearLockageYearIncrease")
    public String recentYearLockageYearIncrease(@RequestParam String shipLock){
        QueryWrapper<TdmRecentYearLockageYearIncreaseDf> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("snid",shipLock);
        try {
            List<TdmRecentYearLockageYearIncreaseDf> tdmRecentYearLockageYearIncreaseDfs = tdmRecentYearLockageYearIncreaseDfService.list(queryWrapper);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("年份");
            jsonArray1.put("总吨");
            jsonArray1.put("核载");
            jsonArray1.put("实载");
            jsonArray1.put("艘次");
            jsonArray.put(jsonArray1);
            for (TdmRecentYearLockageYearIncreaseDf tdmRecentYearLockageYearIncreaseDf : tdmRecentYearLockageYearIncreaseDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmRecentYearLockageYearIncreaseDf.getFzDate());
                jsonArray2.put(Double.parseDouble(tdmRecentYearLockageYearIncreaseDf.getTotTonIncrease())+1);
                jsonArray2.put(Double.parseDouble(tdmRecentYearLockageYearIncreaseDf.getNclsCrryTnsIncrease())+1);
                jsonArray2.put(Double.parseDouble(tdmRecentYearLockageYearIncreaseDf.getCrgDdwghtTnsIncrease())+1);
                jsonArray2.put(Double.parseDouble(tdmRecentYearLockageYearIncreaseDf.getCzCountIncrease())+1);
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

    //西江流域过去一年过闸数据同比变化
    @RequestMapping("/thisYearEachMonthLockage")
    public String thisYearEachMonthLockage(@RequestParam String shipLock){
        QueryWrapper<TdmThisYearEachMonthLockageDf> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("snid",shipLock);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String year = simpleDateFormat.format(new Date());
        try {
            List<TdmThisYearEachMonthLockageDf> tdmThisYearEachMonthLockageDfs = tdmThisYearEachMonthLockageDfService.list(queryWrapper);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("月份");
            jsonArray1.put("总吨");
            jsonArray1.put("核载");
            jsonArray1.put("实载");
            jsonArray1.put("艘次");
            jsonArray.put(jsonArray1);
            for (TdmThisYearEachMonthLockageDf tdmThisYearEachMonthLockageDf : tdmThisYearEachMonthLockageDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(year+"/"+tdmThisYearEachMonthLockageDf.getFzMonth());
                jsonArray2.put(Double.parseDouble(tdmThisYearEachMonthLockageDf.getTotTonIncrease())+1);
                jsonArray2.put(Double.parseDouble(tdmThisYearEachMonthLockageDf.getNclsCrryTns())+1);
                jsonArray2.put(Double.parseDouble(tdmThisYearEachMonthLockageDf.getCrgDdwghtTns())+1);
                jsonArray2.put(Double.parseDouble(tdmThisYearEachMonthLockageDf.getCzCount())+1);
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


    //各船闸本年预测过闸数据
    @RequestMapping("/thisYearForecast")
    public String thisYearForecast(){
        try {
            List<TdmThisYearEachShiplockForecastDfDTO> forecastAndActual = tdmThisYearEachShiplockForecastDfService.getForecastAndActual();
            List<TdmThisYearEachShiplockForecastDfDTO> tdmThisYearEachShiplockForecastDfDTOS = forecastAndActual.stream().filter(tdmThisYearEachShiplockForecastDfDTO -> {
                return tdmThisYearEachShiplockForecastDfDTO.getShowType().equals("本年") ? true : false;
            })
                    .collect(Collectors.toList());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("船闸");
            jsonArray1.put("预测过闸");
            jsonArray1.put("实际过闸");
            jsonArray.put(jsonArray1);
            for (TdmThisYearEachShiplockForecastDfDTO tdmThisYearEachShiplockForecastDfDTO : tdmThisYearEachShiplockForecastDfDTOS) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmThisYearEachShiplockForecastDfDTO.getDataType());
                jsonArray2.put(tdmThisYearEachShiplockForecastDfDTO.getForecastCzCount());
                jsonArray2.put(tdmThisYearEachShiplockForecastDfDTO.getActualCzCount());
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

    //各船闸本月预测过闸数据
    @RequestMapping("/thisMonthForecast")
    public String thisMonthForecast(){
        try {
            List<TdmThisYearEachShiplockForecastDfDTO> forecastAndActual = tdmThisYearEachShiplockForecastDfService.getForecastAndActual();
            List<TdmThisYearEachShiplockForecastDfDTO> tdmThisYearEachShiplockForecastDfDTOS = forecastAndActual.stream().filter(tdmThisYearEachShiplockForecastDfDTO -> {
                return tdmThisYearEachShiplockForecastDfDTO.getShowType().equals("本月") ? true : false;
            })
                    .collect(Collectors.toList());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("船闸");
            jsonArray1.put("预测过闸");
            jsonArray1.put("实际过闸");
            jsonArray.put(jsonArray1);
            for (TdmThisYearEachShiplockForecastDfDTO tdmThisYearEachShiplockForecastDfDTO : tdmThisYearEachShiplockForecastDfDTOS) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmThisYearEachShiplockForecastDfDTO.getDataType());
                jsonArray2.put(tdmThisYearEachShiplockForecastDfDTO.getForecastCzCount());
                jsonArray2.put(tdmThisYearEachShiplockForecastDfDTO.getActualCzCount());
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

    //船舶报道方式统计
    //tdm_ship_gate_way_count_df
    @Autowired
    private ITdmShipGateWayCountDfService tdmShipGateWayCountDfService;
    @RequestMapping("/shipgateWayCount")
    public String shipgateWayCount(){//总览后续可以删除
        try {
            List<TdmShipGateWayCountDf> tdmShipGateWayCountDfs = tdmShipGateWayCountDfService.list();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("船闸");
            jsonArray1.put("北斗过闸数");
            jsonArray1.put("实际过闸数");
            jsonArray.put(jsonArray1);
            for (TdmShipGateWayCountDf tdmShipGateWayCountDf : tdmShipGateWayCountDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmShipGateWayCountDf.getSnid());
                jsonArray2.put(tdmShipGateWayCountDf.getBeidouCount());
                jsonArray2.put(tdmShipGateWayCountDf.getTotalCount());
                jsonArray.put(jsonArray2);
            }
            jsonObject.put("content",jsonArray);
            return jsonArray.toString();
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


    //船舶收费方式统计
    //ddl_tdm_payment_method_distribution










}
