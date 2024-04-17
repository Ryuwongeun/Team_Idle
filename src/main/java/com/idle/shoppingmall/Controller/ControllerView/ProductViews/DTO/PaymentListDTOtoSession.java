package com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentListResponse {
    private Long id;
    private String name;
    private String size;
}
