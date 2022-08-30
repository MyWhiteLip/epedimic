package com.example.seu.web.EpidemicData;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.seu.controller.SystemControllerLog;
import com.example.seu.entity.EpidemicData;
import com.example.seu.service.AreaIdService;
import com.example.seu.service.EpidemicDataService;
import com.example.seu.system.ResultData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class EpidemicDataAPI {
    @Resource
    EpidemicDataService epidemicDataService;
    @Resource
    AreaIdService areaIdService;

    @PostMapping("/getAllEpidemicData")
    @SystemControllerLog(operate = "获得所有疫情数据",module = "疫情数据")
    public ResultData getAllEpidemicData() {
        List<EpidemicData> epidemicData = epidemicDataService.queryAll();
        if(epidemicData!=null) {
            return ResultData.success(epidemicData);
        }
        else {
            return ResultData.error("something wrong");
        }
    }

    @PostMapping("/getAllEpidemicDataById")
    @SystemControllerLog(operate = "根据城市id获得所有疫情",module = "疫情数据")
    public ResultData getAllEpidemicDataById(@RequestBody Map<String, Object> map) {
        EpidemicData epidemicData;
        if (map.containsKey("cityId")){
            epidemicData = epidemicDataService.queryAllByCityId((Integer) map.get("cityId"));
        }
        else {
            epidemicData = epidemicDataService.queryAllByProvinceId((Integer) map.get("provinceId"));
        }
        if(epidemicData!=null){
            return ResultData.success(epidemicData);
        }
        else {
            return ResultData.error("something wrong");
        }
    }

    @PostMapping("/getChinaEpidemicDataByDate")
    @SystemControllerLog(operate = "获得所有疫情数据根据日期",module = "疫情数据")
    public ResultData getChinaEpidemicDataByDate(@RequestBody Map<String, Object> map) {
        java.sql.Date date = java.sql.Date.valueOf((String) map.get("date"));
        List<EpidemicData> epidemicData = epidemicDataService.queryChinaEpidemicData(date);
        List<JSONObject> jsonObjects = new ArrayList<>();
        if (epidemicData!=null){
            for (EpidemicData data : epidemicData) {
                JSONObject json = (JSONObject) JSON.toJSON(data);
                json.put("provinceName", areaIdService.searchAreaByAreaId((Integer) json.get("provinceId")));
                jsonObjects.add(json);
            }
            return ResultData.success(jsonObjects);
        }
        else {
            return ResultData.error("wrong");
        }
    }

    @PostMapping("/getProvinceEpidemicDataByNameAndDate")
    @SystemControllerLog(operate = "获得所有疫情数据根据名与日期",module = "疫情数据")
    public ResultData getProvinceEpidemicDataByNameAndDate(@RequestBody Map<String, Object> map) {
        java.sql.Date date = java.sql.Date.valueOf((String) map.get("date"));
        String provinceName = (String) map.get("provinceName");
        int provinceId = areaIdService.searchAreaIdByArea(provinceName);

        List<EpidemicData> epidemicData = epidemicDataService.queryProvinceEpidemicData(date, provinceId);
        List<JSONObject> jsonObjects = new ArrayList<>();
        if (epidemicData!=null){
            for (EpidemicData data : epidemicData) {
                if (data.getCityId() != null) {
                    JSONObject json = (JSONObject) JSON.toJSON(data);
                    json.put("cityName", areaIdService.searchAreaByAreaId((Integer) json.get("cityId")));
                    jsonObjects.add(json);
                }
            }
            return ResultData.success(jsonObjects);
        }
        else {
            return ResultData.error("wrong");
        }
    }
//    @PostMapping("/getAllProvinceEpidemicData")
//    public ResultData getAllProvinceEpidemicData() {
//        Date date = new Date();
//        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
//        String last_time = dtf.format(date);
//        System.out.println(last_time);
//        List<EpidemicData> epidemicData = epidemicDataService.queryProvinceEpidemicData(java.sql.Date.valueOf(last_time));
//        List<JSONObject> jsonObjects = new ArrayList<>();
////        System.out.println(123);
//        if (epidemicData!=null){
//            for (EpidemicData data : epidemicData) {
//                JSONObject json = (JSONObject) JSON.toJSON(data);
//                json.put("provinceName", areaIdService.searchAreaByAreaId((Integer) json.get("provinceId")));
////                System.out.println(json);
//                jsonObjects.add(json);
//            }
//            return ResultData.success(jsonObjects);
//        }
//        else {
//            return ResultData.error("wrong");
//        }
//    }
}
