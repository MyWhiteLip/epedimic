package com.example.seu.mapper;

import com.example.seu.entity.PopulationOut;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
* @author 22962
* @description 针对表【population_out】的数据库操作Mapper
* @createDate 2022-08-15 13:04:12
* @Entity com.example.seu.entity.PopulationOut
*/

public interface PopulationOutMapper extends BaseMapper<PopulationOut> {
    int deleteById(int id);
    int add(PopulationOut populationOut);
    List<PopulationOut> getPopulationOutByCityId(int cityId, Date date);
}
