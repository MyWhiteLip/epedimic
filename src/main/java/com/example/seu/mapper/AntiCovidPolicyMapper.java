package com.example.seu.mapper;

import com.example.seu.entity.AntiCovidPolicy;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
* @author 22962
* @description 针对表【anti_covid_policy】的数据库操作Mapper
* @createDate 2022-08-15 13:04:12
* @Entity com.example.seu.entity.AntiCovidPolicy
*/
public interface AntiCovidPolicyMapper extends BaseMapper<AntiCovidPolicy> {
    void addANTI_CovidPolicy(AntiCovidPolicy acp);

}
