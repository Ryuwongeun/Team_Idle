package com.idle.shoppingmall.RequestDTO.Cart;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartAddRequest {

    @NotNull
    private Long product_id;
    @NotNull
    private String size;
    @Min(1)
    private int count;
} // end class
