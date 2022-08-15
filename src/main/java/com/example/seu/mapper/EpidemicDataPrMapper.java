package com.example.seu.mapper;

import com.example.seu.entity.EpidemicDataPr;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
* @author 22962
* @description 针对表【epidemic_data_pr】的数据库操作Mapper
* @createDate 2022-08-15 13:04:12
* @Entity com.example.seu.entity.EpidemicDataPr
*/
public interface EpidemicDataPrMapper extends BaseMapper<EpidemicDataPr> {
    int deleteById(int id);

    int add(EpidemicDataPr epidemicDataPr);
}
