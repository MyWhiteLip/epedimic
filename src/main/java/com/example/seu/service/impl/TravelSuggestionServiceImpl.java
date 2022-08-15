package com.example.seu.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.seu.entity.TravelSuggestion;
import com.example.seu.service.TravelSuggestionService;
import com.example.seu.mapper.TravelSuggestionMapper;
import org.springframework.stereotype.Service;

/**
* @author 22962
* @description 针对表【travel_suggestion】的数据库操作Service实现
* @createDate 2022-08-15 13:04:12
*/
@Service
public class TravelSuggestionServiceImpl extends ServiceImpl<TravelSuggestionMapper, TravelSuggestion>
implements TravelSuggestionService{

}