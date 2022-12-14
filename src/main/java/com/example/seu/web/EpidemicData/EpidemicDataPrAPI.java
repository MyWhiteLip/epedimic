package com.example.seu.web.EpidemicData;

import com.example.seu.controller.SystemControllerLog;
import com.example.seu.entity.EpidemicData;
import com.example.seu.entity.EpidemicDataPr;
import com.example.seu.service.AreaIdService;
import com.example.seu.service.EpidemicDataPrService;
import com.example.seu.service.EpidemicDataService;
import com.example.seu.system.ResultData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSException;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class EpidemicDataPrAPI {
    @Resource
    EpidemicDataPrService edps;
    @PostMapping("/getEpidemicDataPr")
    @SystemControllerLog(operate = "根据国家获得所有疫情预测数据",module = "疫情数据")
    public ResultData getEpidemicDataPr(@RequestBody Map<String, Object> params)
    {
        if (params.containsKey("country"))
        {
            List<EpidemicDataPr> list=edps.getAllEpidemicDataPrList(params.get("country").toString());
            if (list!=null )
            {
                for (EpidemicDataPr  epd:list)
                {
                    if (epd.getConfirmIncrease()<0)
                    {
                        epd.setConfirmIncrease(0);
                    }
                }
                return ResultData.success(list);
            }
            else
            {
                return ResultData.error("error");
            }

        }
        else {
            return  ResultData.error("error");
        }

    }
    @PostMapping("/getTodayEpidemicPrData")
    @SystemControllerLog(operate = "获得世界今日疫情数据",module = "疫情数据")
    public ResultData getTodayEpidemicPrData()
    {
        return ResultData.success(edps.getAllEpidemicDataWorld());
    }

    @PostMapping("/getAllEpidemicPrData")
    @SystemControllerLog(operate = "获得所有疫情预测数据",module = "疫情数据")
    public ResultData getAllEpidemicPrData()
    {
        return ResultData.success(edps.getAll());
    }

}