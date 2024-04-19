package com.idle.shoppingmall.ResponseDTO.Manage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MProductListView {
    private Long id;
    private String brand_name;
    private String product_name;
    private int price;
    private Long amount;
    private Long sales;
}
