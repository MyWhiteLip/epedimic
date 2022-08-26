package com.example.seu.web.Population;

import com.example.seu.entity.PopulationIn;
import com.example.seu.entity.PopulationOut;
import com.example.seu.service.AreaIdService;
import com.example.seu.service.PopulationInService;
import com.example.seu.service.PopulationOutService;
import com.example.seu.service.RiskScoreService;
import com.example.seu.system.ResultData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@CrossOrigin("*")
public class Population {
    @Resource
    PopulationInService plis;
    @Resource
    PopulationOutService plos;
    @Resource
    AreaIdService ais;
    @Resource
    RiskScoreService rss;

    @PostMapping("/getPopulationInByCityId")
    public ResultData getPopulationIn(@RequestBody Map<String, Object> params){
        if (params.containsKey("cityId"))
        {
            JSONArray ja=new JSONArray();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date=LocalDate.now();
            date=date.plusDays(-1);
            String last_time = dtf.format(date);
            System.out.println(last_time);
            List<PopulationIn> result=plis.getPopulationInList(Integer.parseInt(params.get("cityId").toString()),java.sql.Date.valueOf(last_time));
            for(PopulationIn each:result)
            {
                JSONObject jo=new JSONObject();
                jo.put("province",ais.searchAreaByAreaId(each.getProvinceId()));
                jo.put("city",ais.searchAreaByAreaId(each.getCityId()));
                jo.put("fromProvince",ais.searchAreaByAreaId(each.getFromProvinceId()));
                jo.put("fromCity",ais.searchAreaByAreaId(each.getFromCityId()));
                jo.put("populationIn",each.getPopulationIn());
                jo.put("time",each.getTime().toString());
                ja.add(jo);
            }
            return ResultData.success(ja);

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
            JSONArray ja=new JSONArray();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date=LocalDate.now();
            date=date.plusDays(-1);
            String last_time = dtf.format(date);
            System.out.println(last_time);
            List<PopulationOut> result=plos.getPopulationOutList(Integer.parseInt(params.get("cityId").toString()),java.sql.Date.valueOf(last_time));
            for(PopulationOut each:result)
            {
                JSONObject jo=new JSONObject();
                jo.put("province",ais.searchAreaByAreaId(each.getProvinceId()));
                jo.put("city",ais.searchAreaByAreaId(each.getCityId()));
                jo.put("toProvince",ais.searchAreaByAreaId(each.getToProvinceId()));
                jo.put("toCity",ais.searchAreaByAreaId(each.getToCityId()));
                jo.put("populationOut",each.getPopulationOut());
                jo.put("time",each.getTime().toString());
                ja.add(jo);
            }
            return ResultData.success(ja);


        }
        else
        {
            return ResultData.error("id error or data not found");
        }
    }
    @PostMapping("/getPopulationAnalysis")
    ResultData getPopulationAnalysis(@RequestBody Map<String, Object> params)
    {

        if (params.containsKey("cityId"))
        {
            String suggestion=rss.getPopulationAnalysis(Integer.parseInt(params.get("cityId").toString()));
            return ResultData.success(suggestion);
        }
        else
        {
            return ResultData.error("id error or data not found");
        }
    }

}
