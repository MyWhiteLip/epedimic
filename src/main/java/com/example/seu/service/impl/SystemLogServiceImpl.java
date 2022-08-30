package com.example.seu.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.seu.entity.SystemLog;
import com.example.seu.service.SystemLogService;
import com.example.seu.mapper.SystemLogMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

/**
* @author 22962
* @description 针对表【system_log】的数据库操作Service实现
* @createDate 2022-08-30 09:05:41
*/
@Service
public class SystemLogServiceImpl extends ServiceImpl<SystemLogMapper, SystemLog>
implements SystemLogService{
    @Resource
    SystemLogMapper slm;

    @Override
    public int insertSystemLog(SystemLog record) {
        return slm.insertSystemLog(record);
    }

    @Override
    public SystemLog getSystemLogById(int id) {
        return slm.selectSystemLogById(id);
    }

    @Override
    public JSONArray selectAll() {
        List<SystemLog> list =  slm.selectSystemLog();
        JSONArray Ja=new JSONArray();
        for (SystemLog each : list)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            JSONObject jo=new JSONObject();
            jo.put("id",each.getId());
            jo.put("module",each.getModule());
            jo.put("date",sdf.format(each.getCreateTime()));
            jo.put("operate",each.getOperate());
            jo.put("code",JSONObject.fromObject(each.getResult()).get("code"));
            String request=JSONArray.fromObject(each.getRequest()).get(0).toString().replace("{","");
            request=request.replace("}","");

            jo.put("request",request);
            Ja.add(jo);
        }
        return Ja;
    }
}
