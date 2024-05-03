package com.idle.shoppingmall.ResponseDTO.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderListViewResponse {
    private Long payment_id;
    private String payment_at;
    private String product_name;
    private String product_img;
    private String size;
    private int count;
    private int total_price;
    private String delivery_state;
}
