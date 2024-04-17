package com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentListViewDTO {
    private String name;
    private int price;
    private String size;
    private String img;
}
