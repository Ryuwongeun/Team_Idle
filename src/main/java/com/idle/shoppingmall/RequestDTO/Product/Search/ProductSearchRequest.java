package com.idle.shoppingmall.RequestDTO.Product.Search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ProductSearchRequest {
    private Long product_id;
    private Long brand_id;
    private Long created_who;
    private String pd_name;
    private int pd_price;
    private String pd_category;
    private int count_love;
}
