package com.idle.shoppingmall.RequestDTO.Product.Add;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ProductLogAddRequest {
    private Long product_id;
    private String size;
    private int count;
    private Long created_who;
}
