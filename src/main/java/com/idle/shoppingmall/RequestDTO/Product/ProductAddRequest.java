package com.idle.shoppingmall.RequestDTO.Product;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductAddRequest {
    private Long brand_id;
    private String pd_name;
    private int pd_price;
    private String pd_category;
} // end class
