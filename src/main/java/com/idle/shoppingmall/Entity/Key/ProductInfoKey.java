package com.idle.shoppingmall.Entity.Key;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductInfoKey {
    private Long product_id;
    private Long brand_id;
    private Long created_who;
    private String pd_name;
    private int pd_price;
    private String pd_category;
    private int count_love;
    private String size;
    private int pd_before_count;
}
