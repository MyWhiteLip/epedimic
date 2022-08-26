package com.example.seu.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.seu.entity.RiskScore;
import com.example.seu.service.RiskScoreService;
import com.example.seu.mapper.RiskScoreMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author 22962
* @description 针对表【risk_score】的数据库操作Service实现
* @createDate 2022-08-26 09:39:42
*/
@Service
public class RiskScoreServiceImpl extends ServiceImpl<RiskScoreMapper, RiskScore>
implements RiskScoreService{
    @Resource
    RiskScoreMapper rsm;

    @Override
    public String getPopulationAnalysis(int cityId) {
        Double score = rsm.getScoreByCityId(cityId);
        if (score>=300)
        {
            return "根据人口流入此地的疫情分析，当前城市有较高疫情发生风险。";
        }
        else if(score<300&&score>=100)
        {
            return "根据人口流入地此地的疫情分析，当前城市有中等疫情发生风险。";
        }
        else {
            return "根据人口流入此地的疫情分析，当前城市疫情发生风险较低。";
        }


    }
}
