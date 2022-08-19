package com.example.seu.mapper;

import com.example.seu.entity.CovidDetectionPoint;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 22962
* @description 针对表【covid_detection_point】的数据库操作Mapper
* @createDate 2022-08-15 13:04:12
* @Entity com.example.seu.entity.CovidDetectionPoint
*/

public interface CovidDetectionPointMapper extends BaseMapper<CovidDetectionPoint> {
    int addCovidDetectionPoint(CovidDetectionPoint cdp);
    int deleteCovidDetectionPoint(Integer id);
    List<CovidDetectionPoint> getAll();
    List<CovidDetectionPoint> getAllByProvinceId(Integer provinceId);
    List<CovidDetectionPoint> getAllByCityId(Integer cityId);
}
