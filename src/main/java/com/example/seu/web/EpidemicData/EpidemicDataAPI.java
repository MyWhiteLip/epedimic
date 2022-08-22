package com.example.seu.web.EpidemicData;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

    @PostMapping("/getAllProvinceEpidemicData")
    public ResultData getAllProvinceEpidemicData() {
        Date date = new Date();
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
        String last_time = dtf.format(date);
        System.out.println(last_time);
        List<EpidemicData> epidemicData = epidemicDataService.queryProvinceEpidemicData(java.sql.Date.valueOf(last_time));
        List<JSONObject> jsonObjects = new ArrayList<>();
//        System.out.println(123);
        if (epidemicData!=null){
            for (EpidemicData data : epidemicData) {
                JSONObject json = (JSONObject) JSON.toJSON(data);
                json.put("provinceName", areaIdService.searchAreaByAreaId((Integer) json.get("provinceId")));
//                System.out.println(json);
                jsonObjects.add(json);
            }
            return ResultData.success(jsonObjects);
        }
        else {
            return ResultData.error("wrong");
        }
    }
}
