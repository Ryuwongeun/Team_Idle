package com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailViewDTO {
    private Long product_id;
    private String product_name;
    private String brand_name;
    private String price;
    private String category;
    private String product_img;
    private List<String> size;
    private List<Integer> amount;
}
