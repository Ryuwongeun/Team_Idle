package com.idle.shoppingmall.ResponseDTO.Manage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MProductDetailView {
    private Long id;
    private String product_name;
    private int price;
    private String brand_name;
    private int count_love;
    private String category;
    private List<detailsObject> details;
}

