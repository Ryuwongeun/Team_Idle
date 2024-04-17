package com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestPayDTO {
    private boolean result;
    private int total_price;
    private String address;
    private String phone;
}
