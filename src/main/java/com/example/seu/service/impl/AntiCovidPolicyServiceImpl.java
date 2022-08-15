package com.example.seu.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.seu.entity.AntiCovidPolicy;
import com.example.seu.service.AntiCovidPolicyService;
import com.example.seu.mapper.AntiCovidPolicyMapper;
import org.springframework.stereotype.Service;

/**
* @author 22962
* @description 针对表【anti_covid_policy】的数据库操作Service实现
* @createDate 2022-08-15 13:04:12
*/
@Service
public class AntiCovidPolicyServiceImpl extends ServiceImpl<AntiCovidPolicyMapper, AntiCovidPolicy>
implements AntiCovidPolicyService{

}
