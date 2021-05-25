package com.shuxi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shuxi.entity.TdmEachShiplockLockageDf;
import com.shuxi.entity.TdmRecentYearLockageYearIncreaseDf;
import com.shuxi.entity.TdmThisYearEachMonthLockageDf;
import com.shuxi.service.ITdmEachShiplockLockageDfService;
import com.shuxi.service.ITdmRecentYearLockageYearIncreaseDfService;
import com.shuxi.service.ITdmThisYearEachMonthLockageDfService;
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

@RestController
public class SecondScreenController {
    @Autowired
    private ITdmEachShiplockLockageDfService tdmEachShiplockLockageDfService;
    @Autowired
    private ITdmThisYearEachMonthLockageDfService tdmThisYearEachMonthLockageDfService;
    @Autowired
    private ITdmRecentYearLockageYearIncreaseDfService tdmRecentYearLockageYearIncreaseDfService;
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




}
