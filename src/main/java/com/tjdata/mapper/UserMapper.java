package com.tjdata.mapper;


import com.tjdata.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user where userName = #{userName}")
    List<User> Login(String userName);

    @Select("select passWord from user where userName = #{userName}")
    String getPassWord(String userName);

    @Insert("insert into user (userName,passWord,UUID) VALUES (#{userName},#{passWord},#{UUID})")
    Integer Regis(@Param("userName") String userName, @Param("passWord") String passWord, @Param("UUID") String UUID);
}
