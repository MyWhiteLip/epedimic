package com.example.seu.web.AntiCovid;

import com.example.seu.entity.AntiCovidPolicy;
import com.example.seu.service.AntiCovidPolicyService;
import com.example.seu.service.TravelSuggestionService;
import com.example.seu.system.ResultData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AntiCovidPolicyAPI {
    @Resource
    AntiCovidPolicyService acps;
    TravelSuggestionService tss;

    @PostMapping("/getPolicy")
    public ResultData getPolicy(@RequestParam("cityId")int cityId, @RequestParam("provinceId")int provinceId)
    {
        ResultData data = new ResultData();
        AntiCovidPolicy msg=acps.getPolicy(provinceId,cityId);
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
