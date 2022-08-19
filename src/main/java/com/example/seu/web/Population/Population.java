package com.example.seu.web.Population;

import com.example.seu.entity.PopulationOut;
import com.example.seu.service.PopulationInService;
import com.example.seu.service.PopulationOutService;
import com.example.seu.system.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class Population {
    @Resource
    PopulationInService plis;
    @Resource
    PopulationOutService plos;

    @PostMapping("/getPopulationInByCityId")
    public ResultData getPopulationIn(@RequestBody Map<String, Object> params){
        if (params.containsKey("cityId"))
        {
            return ResultData.success(plis.getPopulationInList(Integer.parseInt(params.get("cityId").toString())));

        }
        else
        {
            return ResultData.error("id error or data not found");
        }


    }
    @PostMapping("/getPopulationOutByCityId")
    public ResultData getPopulationOut(@RequestBody Map<String, Object> params){
        if (params.containsKey("cityId"))
        {

            return ResultData.success(plos.getPopulationOutList(Integer.parseInt(params.get("cityId").toString())));

        }
        else
        {
            return ResultData.error("id error or data not found");
        }


    }

}
