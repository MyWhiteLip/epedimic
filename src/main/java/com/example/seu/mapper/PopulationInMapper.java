package com.example.seu.mapper;

import com.example.seu.entity.PopulationIn;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.seu.entity.PopulationOut;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
* @author 22962
* @description 针对表【population_in】的数据库操作Mapper
* @createDate 2022-08-15 13:04:12
* @Entity com.example.seu.entity.PopulationIn
*/

public interface PopulationInMapper extends BaseMapper<PopulationIn> {
    int deleteById(int id);

    int add(PopulationIn populationIn);
    List<PopulationIn> getPopulationInByCityId(int cityId, Date date);

}
