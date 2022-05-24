package com.example.seu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import  com.example.seu.pojo.User;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CategoryMapper {
    @Select("select * from user ")
    List<User> findAll();

    @Select("select * from user where user= #{user} ")
    User getuser(String user);

    @Select("insert into user (user,password,img,name,chatmessagelist,userlist,marked) values (#{user},#{password},#{img},#{name},#{chatmessagelist},#{userlist},#{marked})")
    void insert(User user);

    @Update({ "update user set chatmessagelist=#{chatmessagelist},userlist=#{userlist},marked=#{marked} where user = #{user}" })
    int Update(User user);

    @Update("update user set name=#{name} where user=#{user}")
    void updatename(User user);
    @Select("select name from user where user=#{user}")
    String getname(String user);
}