package com.tjdata.mapper;

import com.tjdata.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrderMapper {


    @Select("select * from `order`")
    List<Order> getAllOrder();

    @Insert("INSERT INTO `order` (userName, orderDate, orderName, brand, specification, amount, description, price, classification, orderStatus ) values (#{userName},#{orderDate},#{orderName},#{brand},#{specification},#{amount},#{description},'0',' ','1') ")
    Integer addOrder(@Param("userName") String userName, @Param("orderDate") String orderDate, @Param("orderName") String orderName, @Param("brand") String brand, @Param("specification") String specification, @Param("amount") Integer amount, @Param("description") String description);

    @Update("update `order` set price=#{price},classification = #{classification},orderStatus=#{orderStatus} where id = #{id}")
    Integer editOrder(@Param("price") String price, @Param("classification") String classification, @Param("orderStatus") String orderStatus, @Param("id") Integer id);

//    @Update("update `order` set orderDate = # {orderDate}")

}