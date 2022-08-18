package com.example.seu.service;

import com.example.seu.entity.AntiCovidPolicy;
import com.baomidou.mybatisplus.service.IService;
import com.example.seu.mapper.AntiCovidPolicyMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
* @author 22962
* @description 针对表【anti_covid_policy】的数据库操作Service
* @createDate 2022-08-15 13:04:12
*/
public interface AntiCovidPolicyService extends IService<AntiCovidPolicy> {

    public int addAntiCovidPolicy(AntiCovidPolicy acp);
    public int deleteAntiCovidPolicy(Integer id);
    public String  getPolicy(int provinceId, int cityId);

}
