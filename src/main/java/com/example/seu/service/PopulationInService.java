package com.example.seu.service;

import com.example.seu.entity.PopulationIn;
import com.baomidou.mybatisplus.service.IService;

import java.util.Date;
import java.util.List;

/**
* @author 22962
* @description 针对表【population_in】的数据库操作Service
* @createDate 2022-08-15 13:04:12
*/
public interface PopulationInService extends IService<PopulationIn> {
    public int addPopulationIn(PopulationIn record);
    public int deletePopulationIn(int id);

    public List<PopulationIn> getPopulationInList(int cityId, Date date);

}
