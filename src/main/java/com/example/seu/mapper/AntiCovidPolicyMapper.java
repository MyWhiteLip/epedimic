package com.example.seu.mapper;

import com.example.seu.entity.AntiCovidPolicy;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 22962
* @description 针对表【anti_covid_policy】的数据库操作Mapper
* @createDate 2022-08-15 13:04:12
* @Entity com.example.seu.entity.AntiCovidPolicy
*/
public interface AntiCovidPolicyMapper extends BaseMapper<AntiCovidPolicy> {
    int addANTI_CovidPolicy(AntiCovidPolicy acp);

    int deleteANTI_CovidPolicy(int id);

    String getAntiCovidPolicy(int provinceId,int cityId);



}
