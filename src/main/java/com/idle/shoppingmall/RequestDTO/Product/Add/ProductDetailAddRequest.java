package com.idle.shoppingmall.RequestDTO.Product.Add;

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
    private Long id;
    @NotNull
    private String size;
    @Min(1)
    private int count;
}
