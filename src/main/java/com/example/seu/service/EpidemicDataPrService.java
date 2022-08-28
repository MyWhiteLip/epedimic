package com.example.seu.service;

import com.example.seu.entity.EpidemicDataPr;
import com.baomidou.mybatisplus.service.IService;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
* @author 22962
* @description 针对表【epidemic_data_pr】的数据库操作Service
* @createDate 2022-08-26 17:20:43
*/
public interface EpidemicDataPrService extends IService<EpidemicDataPr> {
    List<EpidemicDataPr> getAllEpidemicDataPrList(String country);
    List<EpidemicDataPr> getAllEpidemicDataWorld();
    List<EpidemicDataPr> getAll();
}
