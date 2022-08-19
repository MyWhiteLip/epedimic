package com.example.seu.web.EpidemicData;

import com.example.seu.entity.CovidDetectionPoint;
import com.example.seu.entity.EpidemicData;
import com.example.seu.service.EpidemicDataService;
import com.example.seu.system.ResultData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class EpidemicDataAPI {
    @Resource
    EpidemicDataService epidemicDataService;

    @PostMapping("/getAllEpidemicData")
    public ResultData getAllEpidemicData() {
        List<EpidemicData> epidemicData = epidemicDataService.queryAll();
        if(epidemicData!=null)
            return ResultData.success(epidemicData);
        else
            return ResultData.error("something wrong");

    }
}
