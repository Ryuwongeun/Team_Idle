package com.idle.shoppingmall.RequestDTO.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ProductDetailAddRequest {
    private Long product_id;
    private String size;
    private int pd_before_count;
    private int pd_sell_count;
}
