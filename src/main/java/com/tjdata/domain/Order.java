package com.tjdata.domain;

import lombok.Data;

@Data
public class Order {
    private Integer id;
    private String userName;
    private String orderDate;
    private String orderName;
    private String brand;
    private String specification;
    private Integer amount;
    private String description;
    private String price;
    private String classification;
    private String orderStatus;
}


