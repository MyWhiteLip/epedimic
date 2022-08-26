package com.example.seu.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.seu.entity.PopulationOut;
import com.example.seu.service.PopulationOutService;
import com.example.seu.mapper.PopulationOutMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
* @author 22962
* @description 针对表【population_out】的数据库操作Service实现
* @createDate 2022-08-15 13:04:12
*/
@Service
public class PopulationOutServiceImpl extends ServiceImpl<PopulationOutMapper, PopulationOut>
implements PopulationOutService{
    @Resource
    PopulationOutMapper pom;
    @Override
    public int addPopulationOut(PopulationOut record)
    {
        return pom.add(record);
    }
    @Override
    public int deletePopulationOut(int id) {
        return pom.deleteById(id);
    }

    @Override
    public List<PopulationOut> getPopulationOutList(int cityId, Date date) {
        return pom.getPopulationOutByCityId(cityId,date);
    }

}
