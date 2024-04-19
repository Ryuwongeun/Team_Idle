package com.idle.shoppingmall.ResponseDTO.Product;

import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductListResponse extends CommonResponse {
    private Long product_id;
    private String product_name;
    private int product_price;
    private int count_love;
    private String product_img;

    public ProductListResponse(Long product_id, String product_name, int product_price, int count_love, String product_img) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.count_love = count_love;
        this.product_img = product_img;
    }

}

