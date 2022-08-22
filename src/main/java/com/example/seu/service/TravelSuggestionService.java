package com.example.seu.service;

import com.example.seu.entity.TravelSuggestion;
import com.baomidou.mybatisplus.service.IService;

/**
* @author 22962
* @description 针对表【travel_suggestion】的数据库操作Service
* @createDate 2022-08-15 13:04:12
*/
public interface TravelSuggestionService extends IService<TravelSuggestion> {
    public int addTravelSuggestion(TravelSuggestion record);
    public int deleteTravelSuggestion(int id);
    public TravelSuggestion getSuggestion(int productId_from,int cityId_from,int productId_to,int cityId_to);

}
