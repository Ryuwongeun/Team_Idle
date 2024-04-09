package com.idle.shoppingmall.ResponseDTO.Product;

import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ProductSearchResponse{
    private Long product_id;
    private Long brand_id;
    private Long created_who;
    private String pd_name;
    private int pd_price;
    private String pd_category;
    private int count_love;

    public ProductSearchResponse(Long product_id
                               , Long brand_id
                               , Long created_who
                               , String pd_name
                               , int pd_price
                               , String pd_category
                               , int count_love) {
        this.product_id = product_id;
        this.brand_id = brand_id;
        this.created_who = created_who;
        this.pd_name = pd_name;
        this.pd_price = pd_price;
        this.pd_category = pd_category;
        this.count_love = count_love;
    }
}

