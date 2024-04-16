package com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartListResponse {
    private Long id;
    private String name;
    private String size;
    private int price;
    private int count;
    private int totalPrice;
}
