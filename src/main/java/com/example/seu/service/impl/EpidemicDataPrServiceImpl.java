package com.example.seu.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.seu.entity.EpidemicDataPr;
import com.example.seu.service.EpidemicDataPrService;
import com.example.seu.mapper.EpidemicDataPrMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
* @author 22962
* @description 针对表【epidemic_data_pr】的数据库操作Service实现
* @createDate 2022-08-26 17:20:43
*/
@Service
public class EpidemicDataPrServiceImpl extends ServiceImpl<EpidemicDataPrMapper, EpidemicDataPr>
implements EpidemicDataPrService{

    @Resource
    EpidemicDataPrMapper edpm;
    @Override
    public List<EpidemicDataPr> getAllEpidemicDataPrList(String country) {
        return edpm.getEpidemicDataPrList(country);
    }

    @Override
    public List<EpidemicDataPr> getAllEpidemicDataWorld() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date=LocalDate.now();
        date=date.plusDays(-1);
        String last_time = dtf.format(date);
        return edpm.getEpidemicDataWorldByDate(java.sql.Date.valueOf(last_time));
    }

    @Override
    public List<EpidemicDataPr> getAll() {
        return edpm.getAll();
    }

}
