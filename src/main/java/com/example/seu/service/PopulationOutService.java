package com.example.seu.service;

import com.example.seu.entity.PopulationOut;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
* @author 22962
* @description 针对表【population_out】的数据库操作Service
* @createDate 2022-08-15 13:04:12
*/
public interface PopulationOutService extends IService<PopulationOut> {
    public int addPopulationOut(PopulationOut record);
    public int deletePopulationOut(int id);
    public List<PopulationOut> getPopulationOutList(int cityId);

}
