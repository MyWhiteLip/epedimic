package com.example.seu.web.CovidDetectionPoint;

import com.example.seu.entity.AntiCovidPolicy;
import com.example.seu.entity.CovidDetectionPoint;
import com.example.seu.service.AntiCovidPolicyService;
import com.example.seu.service.CovidDetectionPointService;
import com.example.seu.system.ResultData;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class CovidDetectionPointAPI {
    @Resource
    CovidDetectionPointService cdps;
    @PostMapping("/getDetectionPoint")
    public ResultData getDetectionPoint(@RequestBody Map<String, Object> map) {
        if (map.containsKey("provinceId") && !map.containsKey("cityId"))
        {
            List<CovidDetectionPoint> msg=cdps.getAllByProvinceId(Integer.parseInt(map.get("provinceId").toString()));
            if (msg!=null)
            {
                return  ResultData.success(msg);

            }
            else
            {
                String error="error id or there are no detection points";
                return  ResultData.error(error);
            }
        }
        else if (map.containsKey("cityId"))
        {
            List<CovidDetectionPoint> msg=cdps.getAllByCityId(Integer.parseInt(map.get("cityId").toString()));
            if (msg!=null)
            {
                return  ResultData.success(msg);
            }
            else
            {
                String error="error id or there are no detection points";
                return  ResultData.error(error);
            }
        }
        else
        {
            String error="error params";
            return ResultData.error(error);
        }


    }
}
