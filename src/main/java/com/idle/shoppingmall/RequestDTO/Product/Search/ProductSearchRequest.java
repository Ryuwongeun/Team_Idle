package com.idle.shoppingmall.RequestDTO.Product.Search;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ProductSearchRequest {
    @NotNull
    private String product_name;
}
