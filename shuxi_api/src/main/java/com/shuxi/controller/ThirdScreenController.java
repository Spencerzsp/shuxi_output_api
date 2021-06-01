package com.shuxi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shuxi.dto.TdmPastYearLokageBasinGoodsDfDTO;
import com.shuxi.dto.TdmPastYearLokageBasinGoodsIncrementDfDTO;
import com.shuxi.dto.TdmTopGoodsCloudChartDfDTO;
import com.shuxi.entity.*;
import com.shuxi.mapper.TdmPastYearLokageBasinGoodsIncreaseDfMapper;
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
    @Autowired
    private ITdmPastYearLokageBasinGoodsIncreaseDfService tdmPastYearLokageBasinGoodsIncreaseDfService;
    @Autowired
    private ITdmTopCityGoodsWeightsDfService tdmTopCityGoodsWeightsDfService;
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


    //流域货运量同比变化（过去一年）（流域）
    //tdm_past_year_lokage_basin_goods_increase_df
    @RequestMapping("/freightTrafficTrendIncrementByValley")
    public String freightTrafficTrendIncrementByValley(@RequestParam String valley){
        try {
            List<TdmPastYearLokageBasinGoodsIncrementDfDTO> tdmPastYearLokageBasinGoodsIncreaseDfServiceUpAndDownCrgDdwghtTns = tdmPastYearLokageBasinGoodsIncreaseDfService.getUpAndDownCrgDdwghtTns();
            List<TdmPastYearLokageBasinGoodsIncrementDfDTO> tdmPastYearLokageBasinGoodsIncrementDfDTOS = tdmPastYearLokageBasinGoodsIncreaseDfServiceUpAndDownCrgDdwghtTns.stream()
                    .filter(tdmPastYearLokageBasinGoodsIncrementDfDTO -> tdmPastYearLokageBasinGoodsIncrementDfDTO.getShowDimension().equals("流域") && tdmPastYearLokageBasinGoodsIncrementDfDTO.getDimensionValues().equals(valley) ? true : false)
                    .collect(Collectors.toList());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("年月");
            jsonArray1.put("上行货物");
            jsonArray1.put("下行货物");
            jsonArray.put(jsonArray1);
            for (TdmPastYearLokageBasinGoodsIncrementDfDTO tdmPastYearLokageBasinGoodsIncrementDfDTO : tdmPastYearLokageBasinGoodsIncrementDfDTOS) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmPastYearLokageBasinGoodsIncrementDfDTO.getFzDate());
                jsonArray2.put(tdmPastYearLokageBasinGoodsIncrementDfDTO.getUpYearChange());
                jsonArray2.put(tdmPastYearLokageBasinGoodsIncrementDfDTO.getDownYearChange());
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

    //流域货运量同比变化（过去一年）（船闸）
    //tdm_past_year_lokage_basin_goods_increase_df
    @RequestMapping("/freightTrafficTrendIncrementByShipLock")
    public String freightTrafficTrendIncrementByShipLock(@RequestParam String shipLock){
        try {
            List<TdmPastYearLokageBasinGoodsIncrementDfDTO> tdmPastYearLokageBasinGoodsIncreaseDfServiceUpAndDownCrgDdwghtTns = tdmPastYearLokageBasinGoodsIncreaseDfService.getUpAndDownCrgDdwghtTns();
            List<TdmPastYearLokageBasinGoodsIncrementDfDTO> tdmPastYearLokageBasinGoodsIncrementDfDTOS = tdmPastYearLokageBasinGoodsIncreaseDfServiceUpAndDownCrgDdwghtTns.stream()
                    .filter(tdmPastYearLokageBasinGoodsIncrementDfDTO -> tdmPastYearLokageBasinGoodsIncrementDfDTO.getShowDimension().equals("船闸") && tdmPastYearLokageBasinGoodsIncrementDfDTO.getDimensionValues().equals(shipLock) ? true : false)
                    .collect(Collectors.toList());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("年月");
            jsonArray1.put("上行货物");
            jsonArray1.put("下行货物");
            jsonArray.put(jsonArray1);
            for (TdmPastYearLokageBasinGoodsIncrementDfDTO tdmPastYearLokageBasinGoodsIncrementDfDTO : tdmPastYearLokageBasinGoodsIncrementDfDTOS) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmPastYearLokageBasinGoodsIncrementDfDTO.getFzDate());
                jsonArray2.put(tdmPastYearLokageBasinGoodsIncrementDfDTO.getUpYearChange());
                jsonArray2.put(tdmPastYearLokageBasinGoodsIncrementDfDTO.getDownYearChange());
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


    //2021年热门城市收发货
    //tdm_top_city_goods_weights_df
    @RequestMapping("/hotCityGoodsWeights")
    public String hotCityGoodsWeights(){
        try {
            List<TdmTopCityGoodsWeightsDf> tdmTopCityGoodsWeightsDfs = tdmTopCityGoodsWeightsDfService.list();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("城市");
            jsonArray1.put("发货数");
            jsonArray1.put("收货数");
            jsonArray.put(jsonArray1);
            for (TdmTopCityGoodsWeightsDf tdmTopCityGoodsWeightsDf : tdmTopCityGoodsWeightsDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmTopCityGoodsWeightsDf.getCity());
                jsonArray2.put(tdmTopCityGoodsWeightsDf.getDprtCrgDdwghtTns());
                jsonArray2.put(tdmTopCityGoodsWeightsDf.getArrTypeCrgDdwghtTns());
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

    //城市收发货情况
    //tdm_top_goods_cloud_chart_df
    @RequestMapping("/cityGetOrSendGoodsInfo")
    public String cityGetOrSendGoodsInfo(){
        try {
            List<TdmTopGoodsCloudChartDfDTO> getOrSendGoodsInfo = tdmTopGoodsCloudChartDfService.getGetOrSendGoodsInfo();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("城市");
            jsonArray1.put("收货");
            jsonArray1.put("发货");
            jsonArray.put(jsonArray1);
            for (TdmTopGoodsCloudChartDfDTO tdmTopGoodsCloudChartDfDTO : getOrSendGoodsInfo) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmTopGoodsCloudChartDfDTO.getCity());
                jsonArray2.put(tdmTopGoodsCloudChartDfDTO.getGetGoods());
                jsonArray2.put(tdmTopGoodsCloudChartDfDTO.getSendGoods());
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
    private IDimShowCityService dimShowCityService;
    //城市收发货情况城市点
    //tdm_top_goods_cloud_chart_df
    @RequestMapping("/cityGetOrSendGoodsInfoByCityPosition")
    public String cityGetOrSendGoodsInfoByCityPosition(){
        try {
            List<DimShowCity> dimShowCities = dimShowCityService.list();
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            for (DimShowCity dimShowCity : dimShowCities) {
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("name",dimShowCity.getCity());
                jsonObject1.put("long",Double.parseDouble(dimShowCity.getLongitude()));
                jsonObject1.put("lat",Double.parseDouble(dimShowCity.getLatitude()));
                jsonObject1.put("value",6);
                jsonArray.put(jsonObject1);
            }
            jsonObject.put("points",jsonArray);
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


    //城市收发货情况-过滤后
    //tdm_top_goods_cloud_chart_df
    @RequestMapping("/cityGetOrSendGoodsInfoByCity")
    public String cityGetOrSendGoodsInfoByCity(){
        try {
            List<TdmTopGoodsCloudChartDfDTO> getOrSendGoodsInfo = tdmTopGoodsCloudChartDfService.getGetOrSendGoodsInfo();
            List<DimShowCity> dimShowCities = dimShowCityService.list();
            ArrayList<String> cities = new ArrayList<>();
            dimShowCities.stream().forEach(dimShowCity -> {
                cities.add(dimShowCity.getCity());
            });
            List<TdmTopGoodsCloudChartDfDTO> tdmTopGoodsCloudChartDfDTOS = getOrSendGoodsInfo.stream().filter(tdmTopGoodsCloudChartDfDTO -> {
                String city = tdmTopGoodsCloudChartDfDTO.getCity();
                if (cities.contains(city)) {
                    return true;
                } else {
                    return false;
                }
            }).collect(Collectors.toList());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("城市");
            jsonArray1.put("收货");
            jsonArray1.put("发货");
            jsonArray.put(jsonArray1);
            for (TdmTopGoodsCloudChartDfDTO tdmTopGoodsCloudChartDfDTO : tdmTopGoodsCloudChartDfDTOS) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmTopGoodsCloudChartDfDTO.getCity());
                jsonArray2.put(tdmTopGoodsCloudChartDfDTO.getGetGoods());
                jsonArray2.put(tdmTopGoodsCloudChartDfDTO.getSendGoods());
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
