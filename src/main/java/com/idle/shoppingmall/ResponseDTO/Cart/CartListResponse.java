package com.idle.shoppingmall.ResponseDTO.Cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartListResponse {
    private Long product_id;
    private String product_name;
    private String size;
    private int product_price;
    private int count;
    private int totalPrice;
    private String img;
}
