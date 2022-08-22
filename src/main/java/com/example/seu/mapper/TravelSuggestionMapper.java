package com.example.seu.mapper;

import com.example.seu.entity.TravelSuggestion;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 22962
* @description 针对表【travel_suggestion】的数据库操作Mapper
* @createDate 2022-08-15 13:04:12
* @Entity com.example.seu.entity.TravelSuggestion
*/
public interface TravelSuggestionMapper extends BaseMapper<TravelSuggestion> {
public  int addTravelSuggestion(TravelSuggestion record);
public int deleteTravelSuggestion(Integer id);
public TravelSuggestion getSuggestion(int provinceId_from,int cityId_from,int provinceId_to,int cityId_to);
}
