package com.tjdata.mapper;

import com.tjdata.domain.Primer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PrimerMapper {


    @Select("select * from primer")
    List<Primer> getAllPrimer();

    @Insert("insert into primer (userName,orderDate,primerName,baseSequence) values (#{userName},#{orderDate},#{primerName},#{baseSequence}) ")
    Integer addPrimer(@Param("userName")String userName,@Param("orderDate")String orderDate,@Param("primerName")String primerName,@Param("baseSequence")String baseSequence);
}
