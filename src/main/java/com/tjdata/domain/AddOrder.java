package com.tjdata.domain;

import lombok.Data;

@Data
public class AddOrder {
    private String userName;
    private String orderDate;
    private String orderName;
    private String brand;
    private String specification;
    private Integer amount;
    private String description;
}
