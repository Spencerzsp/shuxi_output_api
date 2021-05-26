package com.shuxi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shuxi.dto.TdmPastYearLokageBasinGoodsDfDTO;
import com.shuxi.entity.TdmPastYearLokageBasinGoodsDf;
import com.shuxi.entity.TdmRecentYearTopCityPieDf;
import com.shuxi.entity.TdmTopCityFormDf;
import com.shuxi.entity.TdmTopGoodsCloudChartDf;
import com.shuxi.service.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: Yu Hao
 * DateTime: 2021-05-26 11:50
 */
@RestController
public class ThirdScreenController {
    @Autowired
    private ITdmRecentYearTopCityPieDfService tdmRecentYearTopCityPieDfService;
    @Autowired
    private ITdmTopCityFormDfService tdmTopCityFormDfService;
    @Autowired
    private ITdmTopGoodsCloudChartDfService tdmTopGoodsCloudChartDfService;
    //2021年西江流域十佳发货地
    //tdm_recent_year_top_city_pie_df
    @RequestMapping("/xjTopStartCity10")
    public String xjTopStartCity10(){
        QueryWrapper<TdmTopCityFormDf> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("city_type","出发地");
        try {
            List<TdmTopCityFormDf> tdmTopCityFormDfs = tdmTopCityFormDfService.list(queryWrapper);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("城市");
            jsonArray1.put("货量");
            jsonArray.put(jsonArray1);
            for (TdmTopCityFormDf tdmTopCityFormDf : tdmTopCityFormDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmTopCityFormDf.getCity());
                jsonArray2.put(tdmTopCityFormDf.getCrgDdwghtTns());
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



    //2021年西江流域十佳收货地
    //tdm_recent_year_top_city_pie_df
    @RequestMapping("/xjTopEndCity10")
    public String xjTopEndCity10(){
        QueryWrapper<TdmTopCityFormDf> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("city_type","目的地");
        try {
            List<TdmTopCityFormDf> tdmTopCityFormDfs = tdmTopCityFormDfService.list(queryWrapper);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("城市");
            jsonArray1.put("货量");
            jsonArray.put(jsonArray1);
            for (TdmTopCityFormDf tdmTopCityFormDf : tdmTopCityFormDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmTopCityFormDf.getCity());
                jsonArray2.put(tdmTopCityFormDf.getCrgDdwghtTns());
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


    //2021年船闸上行货物分布（流域）
        @RequestMapping("/thisYearUpGoodsDistributionByValley")
    public String thisYearUpGoodsDistributionByValley(@RequestParam String valley){
        QueryWrapper<TdmTopGoodsCloudChartDf> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("show_dimension","流域").eq("dimension_values",valley).eq("count_type","上行");
        try {
            List<TdmTopGoodsCloudChartDf> tdmTopGoodsCloudChartDfs = tdmTopGoodsCloudChartDfService.list(queryWrapper);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("货物名");
            jsonArray1.put("货量");
            jsonArray.put(jsonArray1);
            for (TdmTopGoodsCloudChartDf tdmTopGoodsCloudChartDf : tdmTopGoodsCloudChartDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmTopGoodsCloudChartDf.getGoodsName());
                jsonArray2.put(tdmTopGoodsCloudChartDf.getCrgDdwghtTns());
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

    //2021年船闸下行货物分布（流域）
    @RequestMapping("/thisYearDownGoodsDistributionByValley")
    public String thisYearDownGoodsDistributionByValley(@RequestParam String valley){
        QueryWrapper<TdmTopGoodsCloudChartDf> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("show_dimension","流域").eq("dimension_values",valley).eq("count_type","下行");
        try {
            List<TdmTopGoodsCloudChartDf> tdmTopGoodsCloudChartDfs = tdmTopGoodsCloudChartDfService.list(queryWrapper);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("货物名");
            jsonArray1.put("货量");
            jsonArray.put(jsonArray1);
            for (TdmTopGoodsCloudChartDf tdmTopGoodsCloudChartDf : tdmTopGoodsCloudChartDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmTopGoodsCloudChartDf.getGoodsName());
                jsonArray2.put(tdmTopGoodsCloudChartDf.getCrgDdwghtTns());
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

    //2021年船闸上行货物分布（船闸）
    @RequestMapping("/thisYearUpGoodsDistributionByShipLock")
    public String thisYearUpGoodsDistributionByShipLock(@RequestParam String shipLock){
        QueryWrapper<TdmTopGoodsCloudChartDf> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("show_dimension","船闸").eq("dimension_values",shipLock).eq("count_type","上行");
        try {
            List<TdmTopGoodsCloudChartDf> tdmTopGoodsCloudChartDfs = tdmTopGoodsCloudChartDfService.list(queryWrapper);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("货物名");
            jsonArray1.put("货量");
            jsonArray.put(jsonArray1);
            for (TdmTopGoodsCloudChartDf tdmTopGoodsCloudChartDf : tdmTopGoodsCloudChartDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmTopGoodsCloudChartDf.getGoodsName());
                jsonArray2.put(tdmTopGoodsCloudChartDf.getCrgDdwghtTns());
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

    //2021年船闸下行货物分布（船闸）
    @RequestMapping("/thisYearDownGoodsDistributionByShipLock")
    public String thisYearDownGoodsDistributionByShipLock(@RequestParam String shipLock){
        QueryWrapper<TdmTopGoodsCloudChartDf> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("show_dimension","船闸").eq("dimension_values",shipLock).eq("count_type","下行");
        try {
            List<TdmTopGoodsCloudChartDf> tdmTopGoodsCloudChartDfs = tdmTopGoodsCloudChartDfService.list(queryWrapper);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("货物名");
            jsonArray1.put("货量");
            jsonArray.put(jsonArray1);
            for (TdmTopGoodsCloudChartDf tdmTopGoodsCloudChartDf : tdmTopGoodsCloudChartDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmTopGoodsCloudChartDf.getGoodsName());
                jsonArray2.put(tdmTopGoodsCloudChartDf.getCrgDdwghtTns());
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


    @Autowired
    private ITdmPastYearLokageBasinGoodsDfService tdmPastYearLokageBasinGoodsDfService;
    //流域货运量趋势图（过去一年）(流域)
    //tdm_past_year_lokage_basin_goods_increase_df
    @RequestMapping("/freightTrafficTrendByValley")
    public String freightTrafficTrendByValley(@RequestParam String valley){
        try {
            List<TdmPastYearLokageBasinGoodsDfDTO> tdmPastYearLokageBasinGoodsDfServiceUpAndDownCrgDdwghtTns = tdmPastYearLokageBasinGoodsDfService.getUpAndDownCrgDdwghtTns();
            List<TdmPastYearLokageBasinGoodsDfDTO> tdmPastYearLokageBasinGoodsDfDTOS = tdmPastYearLokageBasinGoodsDfServiceUpAndDownCrgDdwghtTns.stream()
                    .filter(tdmPastYearLokageBasinGoodsDfDTO -> tdmPastYearLokageBasinGoodsDfDTO.getShowDimension().equals("流域") && tdmPastYearLokageBasinGoodsDfDTO.getDimensionValues().equals(valley) ? true : false)
                    .collect(Collectors.toList());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("年月");
            jsonArray1.put("上行货物");
            jsonArray1.put("下行货物");
            jsonArray.put(jsonArray1);
            for (TdmPastYearLokageBasinGoodsDfDTO tdmPastYearLokageBasinGoodsDfDTO : tdmPastYearLokageBasinGoodsDfDTOS) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmPastYearLokageBasinGoodsDfDTO.getFzDate());
                jsonArray2.put(tdmPastYearLokageBasinGoodsDfDTO.getUpCrgDdwghtTns());
                jsonArray2.put(tdmPastYearLokageBasinGoodsDfDTO.getDownCrgDdwghtTns());
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


    //流域货运量趋势图（过去一年）(船闸)
    //tdm_past_year_lokage_basin_goods_increase_df
    @RequestMapping("/freightTrafficTrendByShipLock")
    public String freightTrafficTrendByShipLock(@RequestParam String shipLock){
        try {
            List<TdmPastYearLokageBasinGoodsDfDTO> tdmPastYearLokageBasinGoodsDfServiceUpAndDownCrgDdwghtTns = tdmPastYearLokageBasinGoodsDfService.getUpAndDownCrgDdwghtTns();
            List<TdmPastYearLokageBasinGoodsDfDTO> tdmPastYearLokageBasinGoodsDfDTOS = tdmPastYearLokageBasinGoodsDfServiceUpAndDownCrgDdwghtTns.stream()
                    .filter(tdmPastYearLokageBasinGoodsDfDTO -> tdmPastYearLokageBasinGoodsDfDTO.getShowDimension().equals("船闸") && tdmPastYearLokageBasinGoodsDfDTO.getDimensionValues().equals(shipLock) ? true : false)
                    .collect(Collectors.toList());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("年月");
            jsonArray1.put("上行货物");
            jsonArray1.put("下行货物");
            jsonArray.put(jsonArray1);
            for (TdmPastYearLokageBasinGoodsDfDTO tdmPastYearLokageBasinGoodsDfDTO : tdmPastYearLokageBasinGoodsDfDTOS) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmPastYearLokageBasinGoodsDfDTO.getFzDate());
                jsonArray2.put(tdmPastYearLokageBasinGoodsDfDTO.getUpCrgDdwghtTns());
                jsonArray2.put(tdmPastYearLokageBasinGoodsDfDTO.getDownCrgDdwghtTns());
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
