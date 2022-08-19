package com.example.seu.web.AntiCovid;

import com.example.seu.entity.AntiCovidPolicy;
import com.example.seu.service.AntiCovidPolicyService;
import com.example.seu.service.TravelSuggestionService;
import com.example.seu.system.ResultData;
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

    @PostMapping("/getPolicy")
    public ResultData getPoldicy(@RequestBody Map<String, Object> map)
    {
        ResultData data = new ResultData();
        int cityId=0;
        if (map.containsKey("cityId"))
        {
            cityId=Integer.parseInt(map.get("cityId").toString());
        }
        AntiCovidPolicy msg=acps.getPolicy(cityId);
        if (msg!=null){
            return ResultData.success(msg);
        }
        else {
            return ResultData.error("policy not found or id error");
        }
    }
    @PostMapping("/getSuggestion")
    public ResultData getSuggestion(@RequestParam("provinceId_from")int provinceId_from,
                                    @RequestParam("cityId_from") int cityId_from,
                                    @RequestParam("provinceId_to")int provinceId_to,
                                    @RequestParam("cityId_to")int cityId_to)
    {
        ResultData data=new ResultData();
        String msg=tss.getSuggestion(provinceId_from,cityId_from,provinceId_to,cityId_to);
        if (msg!=null){
            return ResultData.success(msg);
        }
        else {
            return ResultData.error("suggestion not found or id error");
        }
    }

}
