package com.shuxi.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shuxi.entity.TdmRecentYearGateDf;
import com.shuxi.entity.TdmShipTonnageDistributionDf;
import com.shuxi.entity.TdmXjMainLineFreightRateDf;
import com.shuxi.service.ITdmRecentYearGateDfService;
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
    @Autowired
    private ITdmRecentYearGateDfService tdmRecentYearGateDfService;
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
            jsonArray.put(jsonArray1);
            for (TdmXjMainLineFreightRateDf tdmXjMainLineFreightRateDf : tdmXjMainLineFreightRateDfs) {
                JSONArray jsonArray2 = new JSONArray();
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
    //运力周指数(船闸)
    @RequestMapping("/capacityWeekIndexByShipLock")
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
            jsonArray.put(jsonArray1);
            for (TdmXjMainLineFreightRateDf tdmXjMainLineFreightRateDf : tdmXjMainLineFreightRateDfs) {
                JSONArray jsonArray2 = new JSONArray();
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
            JSONArray jsonArray = new JSONArray();
            jsonArray.put("流域");
            jsonArray.put("右江");
            jsonArray.put("郁江");
            jsonArray.put("浔江");
            jsonArray.put("柳江");
            jsonArray.put("黔江");
            jsonArray.put("红水河");
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

    //下拉（城市）
    @RequestMapping("/pullDownByCity")
    public String pullDownByCity(){
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            jsonArray.put("城市");
            jsonArray.put("南宁");
            jsonArray.put("柳州");
            jsonArray.put("桂林");
            jsonArray.put("梧州");
            jsonArray.put("北海");
            jsonArray.put("防城港");
            jsonArray.put("钦州");
            jsonArray.put("贵港");
            jsonArray.put("玉林");
            jsonArray.put("百色");
            jsonArray.put("贺州");
            jsonArray.put("河池");
            jsonArray.put("来宾");
            jsonArray.put("崇左");
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


    //下拉（船闸）
    @RequestMapping("/pullDownByShipLock")
    public String pullDownByShipLock(){
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("success",true);
            JSONArray jsonArray = new JSONArray();
            jsonArray.put("船闸");
            jsonArray.put("那吉");
            jsonArray.put("老口");
            jsonArray.put("长洲");
            jsonArray.put("贵港");
            jsonArray.put("桂平");
            jsonArray.put("金鸡");
            jsonArray.put("红花");
            jsonArray.put("西津");
            jsonArray.put("大藤峡");
            jsonArray.put("鱼梁");
            jsonArray.put("邕宁");
            jsonArray.put("桥巩");
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
