package com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesDTO {
    private Long product_id;
    private String size;
    private int count;
}
