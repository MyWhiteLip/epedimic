package com.example.seu.mapper;

import com.example.seu.pojo.House;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HouseMapper {
    @Select("select * from house")
    List<House> finall();
    @Select("select * from house where host= #{user} ")
    List<House> getHouseByUser(String user);
    @Select("insert into house (neighborhood,district,type,area,cost,layer,joint,information,host,img) values (#{neighborhood},#{district},#{type},#{area},#{cost},#{layer},#{joint},#{information},#{host},#{img})")
    void insert(House house);
    @Select("select * from house where neighborhood= #{neighborhood} and district=#{district} and type=#{type} and area=#{area} and cost=#{cost} and layer=#{layer} and joint= #{joint} and information=#{information} and host=#{host}")
    House searchequal(House house);
    @Select("update house set img=#{img} where neighborhood= #{neighborhood} and district=#{district} and type=#{type} and area=#{area} and cost=#{cost} and layer=#{layer} and joint= #{joint} and information=#{information} and host=#{host} ")
    void updataimg(House house);
    @Select("select * from house where id = #{id}")
    House getHouseById(Integer id);
    @Delete("delete from house where id=#{id}")
    void deleteById(Integer id);


}
