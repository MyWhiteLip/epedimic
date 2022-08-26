package com.example.seu.mapper;

import com.example.seu.entity.EpidemicDataPr;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
* @author 22962
* @description 针对表【epidemic_data_pr】的数据库操作Mapper
* @createDate 2022-08-26 17:20:43
* @Entity com.example.seu.entity.EpidemicDataPr
*/
public interface EpidemicDataPrMapper extends BaseMapper<EpidemicDataPr> {
    List<EpidemicDataPr> getEpidemicDataPrList(String country);


}
