package com.shuxi.controller;

import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shuxi.entity.*;
import com.shuxi.service.IDimCityPositionService;
import com.shuxi.service.ITdmTopVoyageFormDfService;
import com.shuxi.service.ITdmVoyageInfoService;
import com.shuxi.service.ITdmVoyageSheetService;
import io.swagger.annotations.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: Yu Hao
 * DateTime: 2021-05-26 19:36
 */
@Api(tags = "四屏接口")
@RestController
public class ForthController {


    @Autowired
    private ITdmTopVoyageFormDfService tdmTopVoyageFormDfService;
    @Autowired
    private ITdmVoyageInfoService tdmVoyageInfoService;
    @Autowired
    private ITdmVoyageSheetService tdmVoyageSheetService;
    //2020年十佳航线
    //tdm_top_voyage_form_df
    @ApiOperation(value = "2020年十佳航线",notes = "仅支持get请求")
    @ApiResponses(@ApiResponse(code = 200,message = "返回json"))
    @GetMapping("/topVoyage2020")
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
    @ApiOperation(value = "2021年十佳航线",notes = "仅支持get")
    @ApiResponses(@ApiResponse(code = 200,message = "返回json"))
    @GetMapping("/topVoyage2021")
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

    //tdm_voyage_info
    //航线总数
    @ApiOperation(value = "航线总数",notes = "返回json")
    @ApiResponses(@ApiResponse(code = 200,message = "返回json"))
    @GetMapping("/totalVoyageNumber")
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
            jsonObject1.put("description","历史累计的航线数量");
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
    @ApiOperation(value = "今年新增航线数",notes = "返回json")
    @ApiResponses(@ApiResponse(code = 200,message = "返回json"))
    @GetMapping("/newVoyageThisYear")
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
            jsonObject1.put("description","今年新增的航线数量");
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
    @ApiOperation(value = "广西发航线数",notes = "返回json")
    @ApiResponses(@ApiResponse(code = 200,message = "返回json"))
    @GetMapping("/gxVoyage")
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
            jsonObject1.put("description","广西发往广东的航线数量");
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
    @ApiOperation(value = "广东发航线数",notes = "返回json")
    @ApiResponses(@ApiResponse(code = 200,message = "返回json"))
    @GetMapping("/gdVoyage")
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
            jsonObject1.put("description","广东发往广西的航线数量");
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


    public static String roundByScale(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The   scale   must   be   a   positive   integer   or   zero");
        }
        if(scale == 0){
            return new DecimalFormat("0").format(v);
        }
        String formatStr = "0.";
        for(int i=0;i<scale;i++){
            formatStr = formatStr + "0";
        }
        return new DecimalFormat(formatStr).format(v);
    }

    //运力、重量（货量）、占比（货量占总货量的占比）、同比（今年同期货量和去年同期的对比）
    //航线屏下方表格
    // tdm_voyage_sheet
    @ApiOperation(value = "运力、重量（货量）、占比（货量占总货量的占比）、同比（今年同期货量和去年同期的对比）",notes = "航线屏下方表格")
    @ApiResponses(@ApiResponse(code = 200,message = "返回json"))
    @GetMapping("/getTop30VoyageInfo")
    public String getTop30VoyageInfo(){
        try {
            List<TdmVoyageSheet> tdmVoyageSheets = tdmVoyageSheetService.list();
            JSONArray jsonArray = new JSONArray();
            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put("航线");
            jsonArray1.put("运力(万吨)");
            jsonArray1.put("货量(万吨)");
            jsonArray1.put("占比");
            jsonArray1.put("同比");
            jsonArray.put(jsonArray1);
            DecimalFormat decimalFormat = new DecimalFormat("0.00#");
            for (TdmVoyageSheet tdmVoyageSheet : tdmVoyageSheets) {
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(tdmVoyageSheet.getDprtPt()+"-"+tdmVoyageSheet.getArrPt());
                jsonArray2.put(decimalFormat.format(NumberUtil.round(Double.parseDouble(tdmVoyageSheet.getNclsCrryTns())/10000,2)));
                jsonArray2.put(decimalFormat.format(NumberUtil.round(Double.parseDouble(tdmVoyageSheet.getCrgDdwghtTns())/10000,2)));
                jsonArray2.put(NumberUtil.round(Double.parseDouble(tdmVoyageSheet.getProportion())*100,1)+"%");
                jsonArray2.put(NumberUtil.round(Double.parseDouble(tdmVoyageSheet.getYearOnYearBasis())*100,2)+"%");
                jsonArray.put(jsonArray2);
            }
            return jsonArray.toString();
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

    //西江流域航线图
    //2021年十佳航线
    //tdmTopVoyageFormDfService
    @Autowired
    private IDimCityPositionService dimCityPositionService;
    @ApiOperation(value = "西江流域航线图,2021年十佳航线",notes = "旧版本")
    @ApiResponses(@ApiResponse(code = 200,message = "返回json"))
    @GetMapping("/voyageMainPicture")
    public String voyageMainPicture() {
        try {
            List<DimCityPosition> dimCityPositions = dimCityPositionService.list();
            HashMap<String, DimCityPosition> hashMap = new HashMap<>();
            for (DimCityPosition dimCityPosition : dimCityPositions) {
                hashMap.put(dimCityPosition.getCity(),dimCityPosition);
            }

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            String year = simpleDateFormat.format(new Date());
            QueryWrapper<TdmTopVoyageFormDf> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("count_year", year);
            List<TdmTopVoyageFormDf> tdmTopVoyageFormDfs = tdmTopVoyageFormDfService.list(queryWrapper);
            JSONArray jsonArray = new JSONArray();
            for (TdmTopVoyageFormDf tdmTopVoyageFormDf : tdmTopVoyageFormDfs) {
                //System.out.println("tdmTopVoyageFormDf = " + tdmTopVoyageFormDf);
                JSONArray jsonArray1 = new JSONArray();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("出发城市",tdmTopVoyageFormDf.getDprtPt());
                jsonObject.put("经度",hashMap.get(tdmTopVoyageFormDf.getArrPt()).getLongitude());
                jsonObject.put("纬度",hashMap.get(tdmTopVoyageFormDf.getArrPt()).getLatitude());
                jsonArray1.put(jsonObject);
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("出发城市",tdmTopVoyageFormDf.getDprtPt());
                jsonObject1.put("经度",hashMap.get(tdmTopVoyageFormDf.getDprtPt()).getLongitude());
                jsonObject1.put("纬度",hashMap.get(tdmTopVoyageFormDf.getDprtPt()).getLatitude());
                jsonArray1.put(jsonObject1);
                jsonArray.put(jsonArray1);
            }
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


 /*   //西江流域航线图城市点
    //2021年十佳航线
    @RequestMapping("/voyageMainPictureCity")
    public String voyageMainPictureCity(){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            String year = simpleDateFormat.format(new Date());
            QueryWrapper<TdmTopVoyageFormDf> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("count_year", year);
            List<TdmTopVoyageFormDf> tdmTopVoyageFormDfs = tdmTopVoyageFormDfService.list(queryWrapper);
            List<DimCityPosition> dimCityPositions = dimCityPositionService.list();
            HashMap<String, DimCityPosition> hashMap = new HashMap<>();
            dimCityPositions.stream().forEach(dimCityPosition -> hashMap.put(dimCityPosition.getCity(),dimCityPosition));
            HashSet<DimCityPosition> hashSet = new HashSet<>();
            tdmTopVoyageFormDfs.stream().forEach(tdmTopVoyageFormDf -> {
                String arrPt = tdmTopVoyageFormDf.getArrPt();
                String dprtPt = tdmTopVoyageFormDf.getDprtPt();
                hashSet.add(hashMap.get(arrPt));
                hashSet.add(hashMap.get(dprtPt));
            });
            JSONArray jsonArray = new JSONArray();
            for (DimCityPosition dimCityPosition : hashSet) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("城市",dimCityPosition.getCity());
                jsonObject.put("lon",Double.parseDouble(dimCityPosition.getLongitude()));
                jsonObject.put("lat",Double.parseDouble(dimCityPosition.getLatitude()));
                jsonArray.put(jsonObject);
            }
            return jsonArray.toString();
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
    }*/

/*    //西江流域航线图城市路线
    @RequestMapping("/voyageMainPicturePath")
    public String voyageMainPicturePath(){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            String year = simpleDateFormat.format(new Date());
            QueryWrapper<TdmTopVoyageFormDf> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("count_year", year);
            List<TdmTopVoyageFormDf> tdmTopVoyageFormDfs = tdmTopVoyageFormDfService.list(queryWrapper);
            List<DimCityPosition> dimCityPositions = dimCityPositionService.list();
            HashMap<String, DimCityPosition> hashMap = new HashMap<>();
            dimCityPositions.stream().forEach(dimCityPosition -> hashMap.put(dimCityPosition.getCity(),dimCityPosition));
            JSONArray jsonArray = new JSONArray();
            for (TdmTopVoyageFormDf tdmTopVoyageFormDf : tdmTopVoyageFormDfs) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("lon",120);
                jsonObject.put("lat",30);
                JSONArray jsonArray1 = new JSONArray();
                JSONArray jsonArray2 = new JSONArray();
                DimCityPosition startCity = hashMap.get(tdmTopVoyageFormDf.getDprtPt());
                jsonArray2.put(Double.parseDouble(startCity.getLongitude()));
                jsonArray2.put(Double.parseDouble(startCity.getLatitude()));
                jsonArray1.put(jsonArray2);
                JSONArray jsonArray3 = new JSONArray();
                DimCityPosition endCity = hashMap.get(tdmTopVoyageFormDf.getArrPt());
                jsonArray3.put(Double.parseDouble(endCity.getLongitude()));
                jsonArray3.put(Double.parseDouble(endCity.getLatitude()));
                jsonArray1.put(jsonArray3);
                jsonObject.put("path",jsonArray1);
                jsonArray.put(jsonObject);
            }
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
    }*/

    //西江流域航线图城市-新
    @ApiOperation(value = "西江流域航线图城市-新",notes = "西江流域航线图城市-新(显示前10的)")
    @ApiResponses(@ApiResponse(code = 200,message = "返回json"))
    @GetMapping("/voyageMainPictureNew")
    public String voyageMainPictureNew(){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            String year = simpleDateFormat.format(new Date());
            QueryWrapper<TdmTopVoyageFormDf> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("count_year", year);
            List<TdmTopVoyageFormDf> tdmTopVoyageFormDfs = tdmTopVoyageFormDfService.list(queryWrapper);
            List<DimCityPosition> dimCityPositions = dimCityPositionService.list();
            HashMap<String, DimCityPosition> hashMap = new HashMap<>();
            dimCityPositions.stream().forEach(dimCityPosition -> hashMap.put(dimCityPosition.getCity(),dimCityPosition));
            HashSet<DimCityPosition> hashSet = new HashSet<>();
            tdmTopVoyageFormDfs.stream().forEach(tdmTopVoyageFormDf -> {
                String arrPt = tdmTopVoyageFormDf.getArrPt();
                String dprtPt = tdmTopVoyageFormDf.getDprtPt();
                hashSet.add(hashMap.get(arrPt));
                hashSet.add(hashMap.get(dprtPt));
            });
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            for (DimCityPosition dimCityPosition : hashSet) {
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("name",dimCityPosition.getCity());
                jsonObject1.put("long",Double.parseDouble(dimCityPosition.getLongitude()));
                jsonObject1.put("lat",Double.parseDouble(dimCityPosition.getLatitude()));
                jsonObject1.put("value",60);
                jsonArray.put(jsonObject1);
            }
            jsonObject.put("points",jsonArray);
            JSONArray jsonArray1 = new JSONArray();
            for (TdmTopVoyageFormDf tdmTopVoyageFormDf : tdmTopVoyageFormDfs) {
                JSONObject jsonObject1 = new JSONObject();
                DimCityPosition arrCity = hashMap.get(tdmTopVoyageFormDf.getArrPt());
                DimCityPosition drptCity = hashMap.get(tdmTopVoyageFormDf.getDprtPt());
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(Double.parseDouble(drptCity.getLongitude()));
                jsonArray2.put(Double.parseDouble(drptCity.getLatitude()));
                jsonObject1.put("from",jsonArray2);
                JSONArray jsonArray3 = new JSONArray();
                jsonArray3.put(Double.parseDouble(arrCity.getLongitude()));
                jsonArray3.put(Double.parseDouble(arrCity.getLatitude()));
                jsonObject1.put("to",jsonArray3);
                jsonArray1.put(jsonObject1);
            }
            jsonObject.put("tracks",jsonArray1);
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
    //西江流域航线图城市-新2
    @ApiOperation(value = "西江流域航线图城市-新",notes = "西江流域航线图城市-新(显示前3的)")
    @ApiResponses(@ApiResponse(code = 200,message = "返回json"))
    @GetMapping("/voyageMainPictureNew2")
    public String voyageMainPictureNew2(){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
            String year = simpleDateFormat.format(new Date());
            QueryWrapper<TdmTopVoyageFormDf> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("count_year", year);
            List<TdmTopVoyageFormDf> tdmTopVoyageFormDfs = tdmTopVoyageFormDfService.list(queryWrapper);
            tdmTopVoyageFormDfs.sort(new Comparator<TdmTopVoyageFormDf>() {
                @Override
                public int compare(TdmTopVoyageFormDf o1, TdmTopVoyageFormDf o2) {
                    return new Double(Double.parseDouble(o2.getCrgDdwghtTns())).compareTo(new Double(Double.parseDouble(o1.getCrgDdwghtTns())));
                }
            });
            ArrayList<TdmTopVoyageFormDf> tdmTopVoyageFormDfs1 = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                tdmTopVoyageFormDfs1.add(tdmTopVoyageFormDfs.get(i));
            }
            List<DimCityPosition> dimCityPositions = dimCityPositionService.list();
            HashMap<String, DimCityPosition> hashMap = new HashMap<>();
            dimCityPositions.stream().forEach(dimCityPosition -> hashMap.put(dimCityPosition.getCity(),dimCityPosition));
            HashSet<DimCityPosition> dimCityPositions1 = new HashSet<>();
            for (TdmTopVoyageFormDf tdmTopVoyageFormDf : tdmTopVoyageFormDfs1) {
                dimCityPositions1.add(hashMap.get(tdmTopVoyageFormDf.getArrPt()));
                dimCityPositions1.add(hashMap.get(tdmTopVoyageFormDf.getDprtPt()));
            }
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            for (DimCityPosition dimCityPosition : dimCityPositions1) {
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("name",dimCityPosition.getCity());
                jsonObject1.put("long",Double.parseDouble(dimCityPosition.getLongitude()));
                jsonObject1.put("lat",Double.parseDouble(dimCityPosition.getLatitude()));
                jsonObject1.put("value",60);
                jsonArray.put(jsonObject1);
            }
            jsonObject.put("points",jsonArray);
            JSONArray jsonArray1 = new JSONArray();
            for (TdmTopVoyageFormDf tdmTopVoyageFormDf : tdmTopVoyageFormDfs1) {
                JSONObject jsonObject1 = new JSONObject();
                DimCityPosition arrCity = hashMap.get(tdmTopVoyageFormDf.getArrPt());
                DimCityPosition drptCity = hashMap.get(tdmTopVoyageFormDf.getDprtPt());
                JSONArray jsonArray2 = new JSONArray();
                jsonArray2.put(Double.parseDouble(drptCity.getLongitude()));
                jsonArray2.put(Double.parseDouble(drptCity.getLatitude()));
                jsonObject1.put("from",jsonArray2);
                JSONArray jsonArray3 = new JSONArray();
                jsonArray3.put(Double.parseDouble(arrCity.getLongitude()));
                jsonArray3.put(Double.parseDouble(arrCity.getLatitude()));
                jsonObject1.put("to",jsonArray3);
                jsonArray1.put(jsonObject1);
            }
            jsonObject.put("tracks",jsonArray1);
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
