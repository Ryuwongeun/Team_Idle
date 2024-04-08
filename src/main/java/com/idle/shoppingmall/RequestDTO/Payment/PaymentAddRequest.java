package com.idle.shoppingmall.RequestDTO.Payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class PaymentAddRequest {
    private Long payment_id;
    private Long product_id;
    private String size;
    private int count;
    private Long created_who;
    private int total_price;

}
