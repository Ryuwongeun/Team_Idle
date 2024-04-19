package com.idle.shoppingmall.RequestDTO.Product.Update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ProductUpdateRequest {
    private Long product_id;
    private String product_name;
    private int product_price;
    private String product_category;
}
