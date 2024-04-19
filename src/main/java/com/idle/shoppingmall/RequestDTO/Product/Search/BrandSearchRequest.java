package com.idle.shoppingmall.RequestDTO.Product.Search;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BrandSearchRequest {
    @NotNull
    String brand_name;
}
