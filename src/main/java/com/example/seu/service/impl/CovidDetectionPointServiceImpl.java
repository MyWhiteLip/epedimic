package com.example.seu.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.seu.entity.CovidDetectionPoint;
import com.example.seu.service.CovidDetectionPointService;
import com.example.seu.mapper.CovidDetectionPointMapper;
import org.springframework.stereotype.Service;

/**
* @author 22962
* @description 针对表【covid_detection_point】的数据库操作Service实现
* @createDate 2022-08-15 13:04:12
*/
@Service
public class CovidDetectionPointServiceImpl extends ServiceImpl<CovidDetectionPointMapper, CovidDetectionPoint>
implements CovidDetectionPointService{

}
