package com.example.seu.web.Manager;

import com.example.seu.service.GeneralLogService;
import com.example.seu.service.SystemLogService;
import com.example.seu.system.ResultData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class Manager {
    @Resource
    SystemLogService sls;
    @Resource
    GeneralLogService gls;
    @PostMapping("/getLog")
    public ResultData getLog()
    {
        return ResultData.success(sls.selectAll());
    }
    @PostMapping("/getLogById")
    public  ResultData getLogById(@RequestBody Map<String,Object> map)
    {
        if (map.containsKey("id"))
        {
            return ResultData.success(sls.getSystemLogById((Integer) map.get("id")));
        }
        else{
            return ResultData.error("error");
        }
    }
    @PostMapping("/getDatabaseLog")
    ResultData getDatabaseLog()
    {
        return ResultData.success(gls.getGeneralLogList());
    }
    @PostMapping("/token")
    ResultData token(@RequestBody Map<String,Object> map)
    {
        if (map.containsKey("token")) {
            if (map.get("token").toString().equals("zztZZT"))
            {
                return ResultData.success("yes");
            }
            else{
                ResultData.error("no!");
            }
        }
        return ResultData.error("no!");
    }
}
