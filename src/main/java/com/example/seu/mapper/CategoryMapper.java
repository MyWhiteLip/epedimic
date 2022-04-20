package com.example.seu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import  com.example.seu.pojo.User;

@Mapper
public interface CategoryMapper {

    @Select("select * from category_ ")
    List<User> findAll();

    @Select("select * from category_ where user= #{user} ")
    User getuser(String user);

    @Select("insert into category_ (user,password) values (#{user},#{password})")
    void insert(User user);

}