package com.example.seu.mapper;

import com.example.seu.entity.AreaId;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 22962
* @description 针对表【area_id】的数据库操作Mapper
* @createDate 2022-08-15 13:04:12
* @Entity com.example.seu.entity.AreaId
*/

public interface AreaIdMapper extends BaseMapper<AreaId> {
    int addArea(AreaId AI);
    int deleteArea(Integer id);


}
