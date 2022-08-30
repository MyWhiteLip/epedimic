package com.example.seu.mapper;

import com.example.seu.entity.GeneralLog;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
* @author 22962
* @description 针对表【general_log(General log)】的数据库操作Mapper
* @createDate 2022-08-30 11:40:08
* @Entity com.example.seu.entity.GeneralLog
*/
public interface GeneralLogMapper extends BaseMapper<GeneralLog> {

    List<GeneralLog> findAllList();

}
