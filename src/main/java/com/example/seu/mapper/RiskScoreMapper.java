package com.example.seu.mapper;

import com.example.seu.entity.RiskScore;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
* @author 22962
* @description 针对表【risk_score】的数据库操作Mapper
* @createDate 2022-08-26 09:39:42
* @Entity com.example.seu.entity.RiskScore
*/
public interface RiskScoreMapper extends BaseMapper<RiskScore> {
 Double getScoreByCityId(int cityId);

}
