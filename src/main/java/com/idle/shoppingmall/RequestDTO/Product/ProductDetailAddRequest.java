package com.idle.shoppingmall.RequestDTO.Product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ProductDetailAddRequest {
    @NotNull
    private Long product_id;

    @NotNull
    private String size;

    @Min(0)
    private int pd_before_count;
}
