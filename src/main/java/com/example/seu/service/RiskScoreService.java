package com.example.seu.service;

import com.example.seu.entity.RiskScore;
import com.baomidou.mybatisplus.service.IService;

/**
* @author 22962
* @description 针对表【risk_score】的数据库操作Service
* @createDate 2022-08-26 09:39:42
*/
public interface RiskScoreService extends IService<RiskScore> {

    String getPopulationAnalysis(int cityId);

}
