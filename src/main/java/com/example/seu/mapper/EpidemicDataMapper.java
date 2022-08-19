package com.example.seu.mapper;

import com.example.seu.entity.EpidemicData;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 22962
* @description 针对表【epidemic_data】的数据库操作Mapper
* @createDate 2022-08-15 13:04:12
* @Entity com.example.seu.entity.EpidemicData
*/

public interface EpidemicDataMapper extends BaseMapper<EpidemicData> {
    int addEpidemicData(EpidemicData ed);
    int deleteEpidemicData(Integer id);
    List<EpidemicData> queryAll();

}
