package com.tjdata.mapper;


import com.tjdata.domain.Vector;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VectorMapper {
    @Select("select vectorName,geneName,geneSequence,RES1,RES2,description from vector")
    List<Vector> getAllVector();

    @Insert("insert into vector (vectorName,geneName,geneSequence,RES1,RES2,description) values (#{vectorName},#{geneName},#{geneSequence},#{RES1},#{RES2},#{description}) ")
    Integer addVector(@Param("vectorName") String vectorName, @Param("geneName") String geneName, @Param("geneSequence") String geneSequence, @Param("RES1") String RES1, @Param("RES2") String RES2, @Param("description") String description);
}
