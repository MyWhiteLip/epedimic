package com.example.seu.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.seu.entity.EpidemicData;
import com.example.seu.service.EpidemicDataService;
import com.example.seu.mapper.EpidemicDataMapper;
import org.springframework.stereotype.Service;

/**
* @author 22962
* @description 针对表【epidemic_data】的数据库操作Service实现
* @createDate 2022-08-15 13:04:12
*/
@Service
public class EpidemicDataServiceImpl extends ServiceImpl<EpidemicDataMapper, EpidemicData>
implements EpidemicDataService{

}
