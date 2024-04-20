package com.idle.shoppingmall.ResponseDTO.Manage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MProductDetailView {
    private Long product_id;
    private String product_name;
    private int product_price;
    private String brand_name;
    private int count_love;
    private String product_category;
    private List<detailsObject> details;
}

