package com.example.seu.service;

import com.example.seu.entity.GeneralLog;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
* @author 22962
* @description 针对表【general_log(General log)】的数据库操作Service
* @createDate 2022-08-30 11:40:08
*/
public interface GeneralLogService extends IService<GeneralLog> {
    List<GeneralLog> getGeneralLogList();
}
