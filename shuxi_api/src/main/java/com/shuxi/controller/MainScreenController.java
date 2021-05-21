package com.shuxi.controller;

import com.shuxi.entity.TdmShipTonnageDistributionDf;
import com.shuxi.service.ITdmShipTonnageDistributionDfService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/valleyShipTonDistributing")
    public String valleyShipTonDistributing() throws JSONException {
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
    }
}
