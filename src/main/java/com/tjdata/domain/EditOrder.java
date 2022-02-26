package com.tjdata.domain;

import lombok.Data;

@Data
public class EditOrder {
    private Integer id;
    private String price;
    private String classification;
    private String orderStatus;
}
