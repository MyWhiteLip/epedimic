package com.example.seu.web.AntiCovid;

import com.example.seu.service.AntiCovidPolicyService;
import com.example.seu.service.TravelSuggestionService;
import com.example.seu.system.ResultData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AntiCovidPolicy {
    @Resource
    AntiCovidPolicyService acps;
    TravelSuggestionService tss;

    @PostMapping("/getPolicy")
    public ResultData getPolicy(@RequestParam("cityId")int cityId, @RequestParam("provinceId")int provinceId)
    {
        ResultData data = new ResultData();
        String msg=acps.getPolicy(provinceId,cityId);
        if (msg!=null)
        {
            data.setMsg(msg);
            data.setCode(400);
        }
        else {

            data.setMsg("policy not found or id error");
            data.setCode(403);
        }
        return data;
    }
    @PostMapping("/getSuggestion")
    public ResultData getSuggestion(@RequestParam("provinceId_from")int provinceId_from,
                                    @RequestParam("cityId_from") int cityId_from,
                                    @RequestParam("provinceId_to")int provinceId_to,
                                    @RequestParam("cityId_to")int cityId_to)
    {
        ResultData data=new ResultData();
        String msg=tss.getSuggestion(provinceId_from,cityId_from,provinceId_to,cityId_to);
        if (msg!=null)
        {
            data.setMsg(msg);
            data.setCode(400);
        }
        else {
            data.setMsg("suggestion not found or id error");
        }
        return data;
    }

}
