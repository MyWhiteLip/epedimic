package com.example.seu.web.AntiCovid;

import com.example.seu.service.AntiCovidPolicyService;
import com.example.seu.system.ResultData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AntiCovidPolicy {
    @Resource
    AntiCovidPolicyService acps;

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
            data.setMsg("suggestion not found or id error");
            data.setCode(403);
        }
        return data;
    }
}
