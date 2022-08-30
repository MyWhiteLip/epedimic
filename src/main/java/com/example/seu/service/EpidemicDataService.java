package com.example.seu.service;

import com.example.seu.entity.EpidemicData;
import com.baomidou.mybatisplus.service.IService;
import com.example.seu.mapper.EpidemicDataMapper;
import com.example.seu.mapper.EpidemicDataPrMapper;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

/**
* @author 22962
* @description 针对表【epidemic_data】的数据库操作Service
* @createDate 2022-08-15 13:04:12
*/
public interface EpidemicDataService extends IService<EpidemicData> {
    int addEpidemicData(EpidemicData record);
    int deleteEpidemicData(Integer id);
    List<EpidemicData> queryAll();
    EpidemicData queryAllByProvinceId(Integer provinceId);

    List<EpidemicData> queryChinaEpidemicData(Date date);
    List<EpidemicData> queryProvinceEpidemicData(Date date, Integer provinceId);
    EpidemicData queryByCityId(Date date, Integer cityId);
}
