package com.example.seu.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.seu.entity.CovidDetectionPoint;
import com.example.seu.service.CovidDetectionPointService;
import com.example.seu.mapper.CovidDetectionPointMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 22962
* @description 针对表【covid_detection_point】的数据库操作Service实现
* @createDate 2022-08-15 13:04:12
*/
@Service
public class CovidDetectionPointServiceImpl extends ServiceImpl<CovidDetectionPointMapper, CovidDetectionPoint>
implements CovidDetectionPointService{
    @Resource
    CovidDetectionPointMapper cdpm;
    @Override
    public int addCovidDetectionPoint(CovidDetectionPoint record)
    {
        return cdpm.addCovidDetectionPoint(record);
    }
    @Override
    public  int deleteCovidDetectionPoint(Integer id)
    {
        return  cdpm.deleteCovidDetectionPoint(id);
    }

    @Override
    public List<CovidDetectionPoint> getALL() {
        return cdpm.getAll();
    }

    @Override
    public List<CovidDetectionPoint> getAllByCityId(Integer cityId) {
        return cdpm.getAllByCityId(cityId);
    }

    @Override
    public List<CovidDetectionPoint> getAllByProvinceId(Integer provinceId) {
        return cdpm.getAllByProvinceId(provinceId);
    }

}
