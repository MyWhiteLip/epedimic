package com.example.seu.web.AntiCovid;

import com.example.seu.controller.SystemControllerLog;
import com.example.seu.entity.AntiCovidPolicy;
import com.example.seu.entity.TravelSuggestion;
import com.example.seu.service.AntiCovidPolicyService;
import com.example.seu.service.AreaIdService;
import com.example.seu.service.TravelSuggestionService;
import com.example.seu.system.IRedisService;
import com.example.seu.system.ResultData;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class AntiCovidPolicyAPI {
    @Resource
    AntiCovidPolicyService acps;
    @Resource
    TravelSuggestionService tss;
    @Resource
    AreaIdService ais;
    @Resource
    IRedisService redisService;

    @PostMapping("/getPolicy")
    @SystemControllerLog(operate = "获得防疫政策",module = "防疫政策")
    public ResultData getPolicy(@RequestBody Map<String, Object> map) {
        ResultData data = new ResultData();
        int cityId = 0;
        if (map.containsKey("cityId")) {
            cityId = Integer.parseInt(map.get("cityId").toString());
        }
        AntiCovidPolicy msg = acps.getPolicy(cityId);
        if (msg != null) {
            return ResultData.success(msg);
        } else {
            return ResultData.error("policy not found or id error");
        }
    }

    @PostMapping("/getSuggestion")
    @SystemControllerLog(operate = "获得建议",module = "疫情数据")
    public ResultData getSuggestion(@RequestBody Map<String,Object>map)
    {
        int cityId_to= (int) map.get("cityInId");
        int cityId_from= (int) map.get("cityOutId");

//        String key=cityId_from+" "+cityId_to;
//        JSONObject joRedis = (JSONObject) redisService.getValue(key);
//        if (joRedis!=null)
//        {
//            return ResultData.success(joRedis);
//        }
//        TravelSuggestion msg=tss.getSuggestion(cityId_from, cityId_to);
        return ResultData.success("test");
    }
}
