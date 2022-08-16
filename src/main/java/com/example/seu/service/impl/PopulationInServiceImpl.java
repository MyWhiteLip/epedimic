package com.example.seu.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.seu.entity.PopulationIn;
import com.example.seu.service.PopulationInService;
import com.example.seu.mapper.PopulationInMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author 22962
* @description 针对表【population_in】的数据库操作Service实现
* @createDate 2022-08-15 13:04:12
*/
@Service
public class PopulationInServiceImpl extends ServiceImpl<PopulationInMapper, PopulationIn>
implements PopulationInService{
    @Resource
    PopulationInMapper pim;
    @Override
    public int addPopulationIn(PopulationIn record)
    {
        return pim.add(record);
    }
    @Override
    public int deletePopulationIn(int id)
    {
        return pim.deleteById(id);
    }

}
