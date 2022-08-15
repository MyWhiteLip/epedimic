package com.example.seu.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.seu.entity.AreaId;
import com.example.seu.service.AreaIdService;
import com.example.seu.mapper.AreaIdMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author 22962
* @description 针对表【area_id】的数据库操作Service实现
* @createDate 2022-08-15 13:04:12
*/
@Service
public class AreaIdServiceImpl extends ServiceImpl<AreaIdMapper, AreaId>
implements AreaIdService{
    @Resource
    AreaIdMapper aim;
    @Override
    public int addAreaId(AreaId record) {
    return aim.addArea(record);
    }
    @Override
    public int deleteAreaId(Integer id)
    {
        return aim.deleteArea(id);
    }


}
