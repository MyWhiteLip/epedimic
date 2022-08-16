package com.example.seu.service;

import com.example.seu.entity.EpidemicData;
import com.baomidou.mybatisplus.service.IService;
import com.example.seu.mapper.EpidemicDataMapper;
import com.example.seu.mapper.EpidemicDataPrMapper;

import javax.annotation.Resource;

/**
* @author 22962
* @description 针对表【epidemic_data】的数据库操作Service
* @createDate 2022-08-15 13:04:12
*/
public interface EpidemicDataService extends IService<EpidemicData> {
    public int addEpidemicData(EpidemicData record);
    public int deleteEpidemicData(Integer id);


}
