package com.example.seu.service;

import com.example.seu.entity.EpidemicData;
import com.example.seu.entity.EpidemicDataPr;
import com.baomidou.mybatisplus.service.IService;

/**
* @author 22962
* @description 针对表【epidemic_data_pr】的数据库操作Service
* @createDate 2022-08-15 13:04:12
*/
public interface EpidemicDataPrService extends IService<EpidemicDataPr> {
    public int addEpidemicDataPr(EpidemicDataPr record);
    public int deleteEpidemicDataPr(Integer id);

}
