package com.shuxi.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shuxi.dto.TdmThisYearShipLockageTypeDfDTO;
import com.shuxi.entity.*;
import com.shuxi.service.*;
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
    @Autowired
    private ITdmRecentYearGateDfService tdmRecentYearGateDfService;
    @Autowired
    private ITdmXjTransportCapacityWeekRateService tdmXjTransportCapacityWeekRateService;
    @Autowired
    private ITdmWaterShipAmountDfService tdmWaterShipAmountDfService;
    @Autowired
    private ITdmBeidouOperationDataDfService tdmBeidouOperationDataDfService;
    @Autowired
    private ITdmBeidouShipAmountDfService tdmBeidouShipAmountDfService;
    @Autowired
    private ITdmThisYearShipLockageTypeDfService tdmThisYearShipLockageTypeDfService;

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
    //货运周指数(流域)
    @RequestMapping("/freightWeeklyIndexByValley")
    public String capacityWeekIndexByValley(@RequestParam String valley){
        QueryWrapper<TdmXjMainLineFreightRateDf> queryWrapper = new QueryWrapper<TdmXjMainLineFreightRateDf>().eq("target", "流域").eq("target_name",valley);
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
            jsonArray1.put("年月");
            jsonArray1.put("上行指数");
            jsonArray1.put("下行指数");
            jsonArray1.put("上行装载率");
            jsonArray1.put("下行装载率");
            jsonArray.put(jsonArray1);
            for (TdmXjMainLineFreightRateDf tdmXjMainLineFreightRateDf : tdmXjMainLineFreightRateDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmXjMainLineFreightRateDf.getMonthDate());
                jsonArray2.put(Double.parseDouble(tdmXjMainLineFreightRateDf.getUpRate()));
                jsonArray2.put(Double.parseDouble(tdmXjMainLineFreightRateDf.getDownRate()));
                jsonArray2.put(Double.parseDouble(tdmXjMainLineFreightRateDf.getUpLoadingRate()));
                jsonArray2.put(Double.parseDouble(tdmXjMainLineFreightRateDf.getDownLoadingRate()));
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
    //货运周指数(船闸)
    @RequestMapping("/freightWeeklyIndexByShipLock")
    public String capacityWeekIndexByShipLock(@RequestParam String shipLock){
        QueryWrapper<TdmXjMainLineFreightRateDf> queryWrapper = new QueryWrapper<TdmXjMainLineFreightRateDf>().eq("target", "船闸").eq("target_name",shipLock);
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
            jsonArray1.put("年月");
            jsonArray1.put("上行指数");
            jsonArray1.put("下行指数");
            jsonArray1.put("上行装载率");
            jsonArray1.put("下行装载率");
            jsonArray.put(jsonArray1);
            for (TdmXjMainLineFreightRateDf tdmXjMainLineFreightRateDf : tdmXjMainLineFreightRateDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmXjMainLineFreightRateDf.getMonthDate());
                jsonArray2.put(Double.parseDouble(tdmXjMainLineFreightRateDf.getUpRate()));
                jsonArray2.put(Double.parseDouble(tdmXjMainLineFreightRateDf.getDownRate()));
                jsonArray2.put(Double.parseDouble(tdmXjMainLineFreightRateDf.getUpLoadingRate()));
                jsonArray2.put(Double.parseDouble(tdmXjMainLineFreightRateDf.getDownLoadingRate()));
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

    //04 西江近年（历年整年）过闸数据(流域)
    @RequestMapping("/passingDataInRecentYearsByVelley")
    public String passingDataInRecentYearsByVelley(@RequestParam String valley){
        QueryWrapper<TdmRecentYearGateDf> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("show_dimension","流域").eq("dimension_values",valley);
        try {
            List<TdmRecentYearGateDf> tdmRecentYearGateDfs = tdmRecentYearGateDfService.list(queryWrapper);
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
            for (TdmRecentYearGateDf tdmRecentYearGateDf : tdmRecentYearGateDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmRecentYearGateDf.getFzDate());
                jsonArray2.put(tdmRecentYearGateDf.getTotTon());
                jsonArray2.put(tdmRecentYearGateDf.getNclsCrryTns());
                jsonArray2.put(tdmRecentYearGateDf.getCrgDdwghtTns());
                jsonArray2.put(tdmRecentYearGateDf.getCzCount());
                jsonArray.put(jsonArray2);
            }
            jsonObject.put("content",jsonArray);
            return jsonObject.toString();
        } catch (Exception e) {
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

    //04 西江近年（历年整年）过闸数据(城市)
    @RequestMapping("/passingDataInRecentYearsByCity")
    public String passingDataInRecentYearsByCity(@RequestParam String city){
        QueryWrapper<TdmRecentYearGateDf> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("show_dimension","城市").eq("dimension_values",city);
        try {
            List<TdmRecentYearGateDf> tdmRecentYearGateDfs = tdmRecentYearGateDfService.list(queryWrapper);
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
            for (TdmRecentYearGateDf tdmRecentYearGateDf : tdmRecentYearGateDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmRecentYearGateDf.getFzDate());
                jsonArray2.put(tdmRecentYearGateDf.getTotTon());
                jsonArray2.put(tdmRecentYearGateDf.getNclsCrryTns());
                jsonArray2.put(tdmRecentYearGateDf.getCrgDdwghtTns());
                jsonArray2.put(tdmRecentYearGateDf.getCzCount());
                jsonArray.put(jsonArray2);
            }
            jsonObject.put("content",jsonArray);
            return jsonObject.toString();
        } catch (Exception e) {
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

    //04 西江近年（历年整年）过闸数据(船闸)
    @RequestMapping("/passingDataInRecentYearsByShipLock")
    public String passingDataInRecentYearsByShipLock(@RequestParam String shipLock){
        QueryWrapper<TdmRecentYearGateDf> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("show_dimension","船闸").eq("dimension_values",shipLock);
        try {
            List<TdmRecentYearGateDf> tdmRecentYearGateDfs = tdmRecentYearGateDfService.list(queryWrapper);
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
            for (TdmRecentYearGateDf tdmRecentYearGateDf : tdmRecentYearGateDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmRecentYearGateDf.getFzDate());
                jsonArray2.put(tdmRecentYearGateDf.getTotTon());
                jsonArray2.put(tdmRecentYearGateDf.getNclsCrryTns());
                jsonArray2.put(tdmRecentYearGateDf.getCrgDdwghtTns());
                jsonArray2.put(tdmRecentYearGateDf.getCzCount());
                jsonArray.put(jsonArray2);
            }
            jsonObject.put("content",jsonArray);
            return jsonObject.toString();
        } catch (Exception e) {
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
    //下拉（流域）
    @RequestMapping("/pullDownByVelley")
    public String pullDownByVelly(){
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONObject jsonObject1 = new JSONObject();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("一级分类");
            jsonObject1.put("keys",jsonArray1);
            JSONArray jsonArray2 = new JSONArray();
            jsonArray2.put("一级分类");
            jsonObject1.put("activeKeys",jsonArray2);
            JSONObject jsonObject2 = new JSONObject();
            jsonObject2.put("一级分类","流域");
            jsonObject1.put("defaultOptions",jsonObject2);

            JSONArray jsonArray = new JSONArray();

            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","右江").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","郁江").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","浔江").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","柳江").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","黔江").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","红水河").put("value",new JSONObject())));
            jsonObject1.put("data",jsonArray);
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

    //下拉（城市）
    @RequestMapping("/pullDownByCity")
    public String pullDownByCity(){
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONObject jsonObject1 = new JSONObject();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("一级分类");
            jsonObject1.put("keys",jsonArray1);
            JSONArray jsonArray2 = new JSONArray();
            jsonArray2.put("一级分类");
            jsonObject1.put("activeKeys",jsonArray2);
            JSONObject jsonObject2 = new JSONObject();
            jsonObject2.put("一级分类","城市");
            jsonObject1.put("defaultOptions",jsonObject2);

            JSONArray jsonArray = new JSONArray();
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","南宁").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","柳州").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","桂林").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","梧州").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","北海").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","防城港").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","钦州").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","贵港").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","玉林").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","百色").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","贺州").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","河池").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","来宾").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","崇左").put("value",new JSONObject())));

            jsonObject1.put("data",jsonArray);
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


    //下拉（船闸）
    @RequestMapping("/pullDownByShipLock")
    public String pullDownByShipLock(){
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONObject jsonObject1 = new JSONObject();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("一级分类");
            jsonObject1.put("keys",jsonArray1);
            JSONArray jsonArray2 = new JSONArray();
            jsonArray2.put("一级分类");
            jsonObject1.put("activeKeys",jsonArray2);
            JSONObject jsonObject2 = new JSONObject();
            jsonObject2.put("一级分类","船闸");
            jsonObject1.put("defaultOptions",jsonObject2);

            JSONArray jsonArray = new JSONArray();

            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","那吉").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","老口").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","长洲").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","贵港").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","桂平").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","金鸡").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","红花").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","西津").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","大藤峡").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","鱼梁").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","邕宁").put("value",new JSONObject())));
            jsonArray.put(new JSONObject().put("一级分类",new JSONObject().put("key","桥巩").put("value",new JSONObject())));

            jsonObject1.put("data",jsonArray);
            jsonObject.put("content",jsonObject1);
            return jsonObject.toString();
        } catch (JSONException e) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("success",false);
                jsonObject.put("message","数据获取失败");
            } catch (JSONException jsonException) {

            }
            return jsonObject.toString();
        }
    }


    //运力周指数(流域)
    @RequestMapping("/capacityWeekIndexByValley")
    public String freightWeeklyIndexByValley(@RequestParam String valley){
        QueryWrapper<TdmXjTransportCapacityWeekRate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("target","流域").eq("target_name",valley).orderByDesc("year_increase").orderByDesc("week_count").last("limit 0,9");
        List<TdmXjTransportCapacityWeekRate> tdmXjTransportCapacityWeekRates = tdmXjTransportCapacityWeekRateService.list(queryWrapper);
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("年份-周数");
            jsonArray1.put("上行指数");
            jsonArray1.put("下行指数");
            for (TdmXjTransportCapacityWeekRate tdmXjTransportCapacityWeekRate : tdmXjTransportCapacityWeekRates) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmXjTransportCapacityWeekRate.getYearIncrease()+"-"+tdmXjTransportCapacityWeekRate.getWeekCount());
                jsonArray2.put(tdmXjTransportCapacityWeekRate.getUpRate());
                jsonArray2.put(tdmXjTransportCapacityWeekRate.getDownRate());
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

    //运力周指数(船闸)
    @RequestMapping("/capacityWeekIndexByShipLock")
    public String freightWeeklyIndexByShipLock(@RequestParam String shipLock){
        QueryWrapper<TdmXjTransportCapacityWeekRate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("target","船闸").eq("target_name",shipLock).orderByDesc("year").orderByDesc("week_count").last("limit 0,9");
        List<TdmXjTransportCapacityWeekRate> tdmXjTransportCapacityWeekRates = tdmXjTransportCapacityWeekRateService.list(queryWrapper);
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("年份-周数");
            jsonArray1.put("上行指数");
            jsonArray1.put("下行指数");
            for (TdmXjTransportCapacityWeekRate tdmXjTransportCapacityWeekRate : tdmXjTransportCapacityWeekRates) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmXjTransportCapacityWeekRate.getYearIncrease()+"-"+tdmXjTransportCapacityWeekRate.getWeekCount());
                jsonArray2.put(tdmXjTransportCapacityWeekRate.getUpRate());
                jsonArray2.put(tdmXjTransportCapacityWeekRate.getDownRate());
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

    //西江近年（历年整年）水运发货量(流域)
    @RequestMapping("/waterTransportationShipmentvolumeInRecentYearsByValley")
    public String waterTransportationShipmentvolumeInRecentYearsByValley(@RequestParam String valley){
        QueryWrapper<TdmWaterShipAmountDf> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("target","流域").eq("target_name",valley);
        try {
            List<TdmWaterShipAmountDf> tdmWaterShipAmountDfs = tdmWaterShipAmountDfService.list(queryWrapper);
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("发货量");
            jsonArray1.put("广西发");
            jsonArray1.put("广东发");
            jsonArray1.put("艘次");
            jsonArray.put(jsonArray1);
            for (TdmWaterShipAmountDf tdmWaterShipAmountDf : tdmWaterShipAmountDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmWaterShipAmountDf.getCountYear());
                jsonArray2.put(tdmWaterShipAmountDf.getShipment());
                jsonArray2.put(tdmWaterShipAmountDf.getGxShipment());
                jsonArray2.put(tdmWaterShipAmountDf.getGdShipment());
                jsonArray2.put(tdmWaterShipAmountDf.getCzCount());
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


    //西江近年（历年整年）水运发货量(船闸)
    @RequestMapping("/waterTransportationShipmentvolumeInRecentYearsByShipLock")
    public String waterTransportationShipmentvolumeInRecentYearsByShipLock(@RequestParam String shipLock){
        QueryWrapper<TdmWaterShipAmountDf> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("target","流域").eq("target_name",shipLock);
        try {
            List<TdmWaterShipAmountDf> tdmWaterShipAmountDfs = tdmWaterShipAmountDfService.list(queryWrapper);
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("发货量");
            jsonArray1.put("广西发");
            jsonArray1.put("广东发");
            jsonArray1.put("艘次");
            jsonArray.put(jsonArray1);
            for (TdmWaterShipAmountDf tdmWaterShipAmountDf : tdmWaterShipAmountDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmWaterShipAmountDf.getCountYear());
                jsonArray2.put(tdmWaterShipAmountDf.getShipment());
                jsonArray2.put(tdmWaterShipAmountDf.getGxShipment());
                jsonArray2.put(tdmWaterShipAmountDf.getGdShipment());
                jsonArray2.put(tdmWaterShipAmountDf.getCzCount());
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

    //指标
    //经常过闸船舶
    @RequestMapping("/oftenLockageShipCount")
    public String oftenLockageShipCount(){
        List<TdmBeidouOperationDataDf> tdmBeidouOperationDataDfs = tdmBeidouOperationDataDfService.list();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("经常过闸船舶数");
            for (TdmBeidouOperationDataDf tdmBeidouOperationDataDf : tdmBeidouOperationDataDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmBeidouOperationDataDf.getOftenLockageShipCount());
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
    //北斗船舶数
    @RequestMapping("/beidouShipAmountDf")
    public String beidouShipAmountDf(){
        List<TdmBeidouShipAmountDf> tdmBeidouShipAmountDfs = tdmBeidouShipAmountDfService.list();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("北斗船舶");
            for (TdmBeidouShipAmountDf tdmBeidouShipAmountDf : tdmBeidouShipAmountDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmBeidouShipAmountDf.getAmount());
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

    //经常过闸船舶运力
    @RequestMapping("/oftenLockageTransportCapacity")
    public String oftenLockageTransportCapacity(){
        List<TdmBeidouOperationDataDf> tdmBeidouOperationDataDfs = tdmBeidouOperationDataDfService.list();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("经常过闸船舶运力");
            for (TdmBeidouOperationDataDf tdmBeidouOperationDataDf : tdmBeidouOperationDataDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmBeidouOperationDataDf.getOftenLockageTransportCapacity());
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


    //北斗船舶运力
    @RequestMapping("/beidouShipShipment")
    public String beidouShipShipment(){
        List<TdmBeidouShipAmountDf> tdmBeidouShipAmountDfs = tdmBeidouShipAmountDfService.list();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("北斗船舶运力");
            for (TdmBeidouShipAmountDf tdmBeidouShipAmountDf : tdmBeidouShipAmountDfs) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmBeidouShipAmountDf.getShipment());
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
    //本年北斗船舶报闸
    @RequestMapping("/thisYearBdLockageCount")
    public String thisYearBdLockageCount(){
        TdmThisYearShipLockageTypeDfDTO tdmThisYearShipLockageTypeDfDTO = tdmThisYearShipLockageTypeDfService.getTdmThisYearShipLockageTypeDfDTO();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("2021年北斗报闸");
            jsonArray.put(jsonArray1);
            JSONArray jsonArray2 = new JSONArray();
            jsonArray2.put(tdmThisYearShipLockageTypeDfDTO.getBdLockageCount());
            jsonArray.put(jsonArray2);
            jsonObject.put("content",jsonObject);
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

    //2021年窗口登记
    @RequestMapping("/thisYearCkLockageCount")
    public String thisYearCkLockageCount(){
        TdmThisYearShipLockageTypeDfDTO tdmThisYearShipLockageTypeDfDTO = tdmThisYearShipLockageTypeDfService.getTdmThisYearShipLockageTypeDfDTO();
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("2021年北斗报闸");
            jsonArray.put(jsonArray1);
            JSONArray jsonArray2 = new JSONArray();
            jsonArray2.put(tdmThisYearShipLockageTypeDfDTO.getCkLockageCount());
            jsonArray.put(jsonArray2);
            jsonObject.put("content",jsonObject);
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


}

