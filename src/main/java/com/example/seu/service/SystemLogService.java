package com.example.seu.service;

import com.example.seu.entity.SystemLog;
import com.baomidou.mybatisplus.service.IService;
import net.sf.json.JSONArray;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


public interface SystemLogService extends IService<SystemLog> {

    int insertSystemLog(SystemLog record);
    SystemLog getSystemLogById(int id);
    JSONArray selectAll();
}
