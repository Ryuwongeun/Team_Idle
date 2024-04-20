package com.idle.shoppingmall.ResponseDTO.Payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentListViewResponse {
    private String name;
    private int price;
    private String size;
    private int count;
    private String img;
}
