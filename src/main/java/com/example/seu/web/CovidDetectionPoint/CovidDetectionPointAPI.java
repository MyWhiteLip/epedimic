package com.example.seu.web.CovidDetectionPoint;

import com.example.seu.entity.AntiCovidPolicy;
import com.example.seu.entity.CovidDetectionPoint;
import com.example.seu.service.AntiCovidPolicyService;
import com.example.seu.service.AreaIdService;
import com.example.seu.service.CovidDetectionPointService;
import com.example.seu.system.ResultData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class CovidDetectionPointAPI {
    @Resource
    CovidDetectionPointService cdps;
    @Resource
    AreaIdService ais;
    @PostMapping("/getDetectionPoint")
    public ResultData getDetectionPoint(@RequestBody Map<String, Object> map) {
        if (map.containsKey("provinceId") && !map.containsKey("cityId"))
        {
            JSONArray ja=new JSONArray();
            List<CovidDetectionPoint> msg=cdps.getAllByProvinceId(Integer.parseInt(map.get("provinceId").toString()));
            if (msg!=null)
            {
                for (CovidDetectionPoint each:msg)
                {
                    JSONObject jo=new JSONObject();
                    jo.put("province",ais.searchAreaByAreaId(each.getProvinceId()));
                    jo.put("city",ais.searchAreaByAreaId(each.getCityId()));
                    String []detail= each.getDetail().split(" ");
                    jo.put("name",detail[0]);
                    jo.put("location",each.getDetail().substring(detail[0].length()+1));
                    ja.add(jo);
                }
                return  ResultData.success(ja);

            }
            else
            {
                String error="error id or there are no detection points";
                return  ResultData.error(error);
            }
        }
        else if (map.containsKey("cityId"))
        {
            JSONArray ja=new JSONArray();
            List<CovidDetectionPoint> msg=cdps.getAllByCityId(Integer.parseInt(map.get("cityId").toString()));
            if (msg!=null)
            {
                for (CovidDetectionPoint each:msg)
                {
                    JSONObject jo=new JSONObject();
                    jo.put("province",ais.searchAreaByAreaId(each.getProvinceId()));
                    jo.put("city",ais.searchAreaByAreaId(each.getCityId()));
                    String []detail= each.getDetail().split(" ");
                    jo.put("name",detail[0]);
                    jo.put("location",each.getDetail().substring(detail[0].length()+1));
                    ja.add(jo);
                }
                return  ResultData.success(ja);
            }
            else
            {
                String error="error id or there are no detection points";
                return  ResultData.error(error);
            }
        }
        else {
            String error="error params";
            return ResultData.error(error);
        }


    }
}
