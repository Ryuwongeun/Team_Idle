package com.idle.shoppingmall.ResponseDTO.Product;

import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ProductListResponse extends CommonResponse {
    private Long product_id;
    private String pd_name;
    private int pd_price;
    private int count_love;
    private String product_img;

    public ProductListResponse(Long product_id, String pd_name, int pd_price, int count_love, String product_img) {
        this.product_id = product_id;
        this.pd_name = pd_name;
        this.pd_price = pd_price;
        this.count_love = count_love;
        this.product_img = product_img;
    }

}

