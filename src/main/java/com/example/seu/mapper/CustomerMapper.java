package com.example.seu.mapper;

import com.example.seu.pojo.customerservice;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CustomerMapper {
    @Insert("insert into customer (username,question) values(#{username},#{question})")
    void insertques(customerservice p);

    @Select("select * from customer")
    List<customerservice> getall();

    @Delete("delete from customer where id=#{id}")
    void deleteByid(int id);

}
