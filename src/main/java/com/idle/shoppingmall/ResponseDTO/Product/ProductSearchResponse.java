package com.idle.shoppingmall.ResponseDTO.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ProductSearchResponse{
    private Long product_id;
    private Long brand_id;
    private Long created_who;
    private String product_name;
    private int product_price;
    private String product_category;
    private int count_love;

    public ProductSearchResponse(Long product_id
                               , Long brand_id
                               , Long created_who
                               , String product_name
                               , int product_price
                               , String product_category
                               , int count_love) {
        this.product_id = product_id;
        this.brand_id = brand_id;
        this.created_who = created_who;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_category = product_category;
        this.count_love = count_love;
    }
}

