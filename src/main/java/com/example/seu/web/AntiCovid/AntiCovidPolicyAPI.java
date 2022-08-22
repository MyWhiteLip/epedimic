package com.example.seu.web.AntiCovid;

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
    public ResultData getSuggestion(@RequestBody Map<String,Object>map)
    {
        int cityId_to= (int) map.get("cityIdTo");
        int cityId_from= (int) map.get("cityIdFrom");
        int provinceId_from= (int) map.get("provinceIdFrom");
        int provinceId_to= (int) map.get("provinceIdTo");
        String key=cityId_from+" "+cityId_to;
        JSONObject joRedis = (JSONObject) redisService.getValue(key);
        if (joRedis!=null)
        {
            return ResultData.success(joRedis);
        }
        TravelSuggestion msg=tss.getSuggestion(provinceId_from,cityId_from,provinceId_to,cityId_to);
        if (msg==null){
            JSONObject jo=new JSONObject();
            TravelSuggestion ts=new TravelSuggestion();
            ts.setCityToId(cityId_to);
            ts.setCityFromId(cityId_from);
            ts.setProvinceFromId(provinceId_from);
            ts.setProvinceToId(provinceId_to);
            jo.put("provinceFrom",ais.searchAreaByAreaId(provinceId_from));
            jo.put("cityFrom",ais.searchAreaByAreaId(cityId_from));
            jo.put("provinceTo",ais.searchAreaByAreaId(provinceId_to));
            jo.put("cityTo",ais.searchAreaByAreaId(cityId_to));
            String suggestion="所在地离开政策： "+acps.getPolicy(cityId_from).getPolicyOut()+" 目的地到达政策："
                    +acps.getPolicy(cityId_to).getPolicyIn()+"  请用户结合两地政策自行判断！";
            jo.put("suggestion",suggestion);
            ts.setSuggestion(suggestion);
            tss.addTravelSuggestion(ts);
            redisService.setValue(key,jo);
            return ResultData.success(jo);
        }
        else {
            JSONObject jo=new JSONObject();
            jo.put("provinceFrom",ais.searchAreaByAreaId(msg.getProvinceFromId()));
            jo.put("cityFrom",ais.searchAreaByAreaId(msg.getCityFromId()));
            jo.put("provinceTo",ais.searchAreaByAreaId(msg.getProvinceToId()));
            jo.put("cityTo",ais.searchAreaByAreaId(msg.getCityToId()));
            jo.put("suggestion",msg.getSuggestion());
            redisService.setValue(key,jo);
            return ResultData.success(jo);
        }

    }
}
