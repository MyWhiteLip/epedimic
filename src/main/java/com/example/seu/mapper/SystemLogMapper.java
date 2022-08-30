package com.example.seu.mapper;

import com.example.seu.entity.SystemLog;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
* @author 22962
* @description 针对表【system_log】的数据库操作Mapper
* @createDate 2022-08-30 09:05:41
* @Entity com.example.seu.entity.SystemLog
*/
public interface SystemLogMapper extends BaseMapper<SystemLog> {

    int insertSystemLog(SystemLog log);
    SystemLog selectSystemLogById(Integer id);
    List<SystemLog> selectSystemLog();

}
