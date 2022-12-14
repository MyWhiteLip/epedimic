package com.example.seu.service;

import com.example.seu.entity.CovidDetectionPoint;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
* @author 22962
* @description 针对表【covid_detection_point】的数据库操作Service
* @createDate 2022-08-15 13:04:12
*/
public interface CovidDetectionPointService extends IService<CovidDetectionPoint> {
    public int addCovidDetectionPoint(CovidDetectionPoint record);
    public int deleteCovidDetectionPoint(Integer id);
    public List<CovidDetectionPoint> getALL();
    public List<CovidDetectionPoint> getAllByCityId(Integer cityId);
    public List<CovidDetectionPoint> getAllByProvinceId(Integer provinceId);



}
