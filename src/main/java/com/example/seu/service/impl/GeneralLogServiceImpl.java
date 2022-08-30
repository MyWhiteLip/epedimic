package com.example.seu.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.seu.entity.GeneralLog;
import com.example.seu.service.GeneralLogService;
import com.example.seu.mapper.GeneralLogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 22962
* @description 针对表【general_log(General log)】的数据库操作Service实现
* @createDate 2022-08-30 11:40:08
*/
@Service
public class GeneralLogServiceImpl extends ServiceImpl<GeneralLogMapper, GeneralLog>
implements GeneralLogService{
    @Resource
    GeneralLogMapper glm;

    @Override
    public List<GeneralLog> getGeneralLogList() {
        return glm.findAllList();
    }
}
