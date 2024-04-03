package com.idle.shoppingmall.RequestDTO.Product.Update;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ProductUpdateRequest {
    private Long product_id;
    private String pd_name;
    private int pd_price;
    private String pd_category;
}
