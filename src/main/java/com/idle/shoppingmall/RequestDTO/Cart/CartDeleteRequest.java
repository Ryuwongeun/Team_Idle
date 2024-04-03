package com.idle.shoppingmall.RequestDTO.Cart;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartDeleteRequest {
    @NotNull
    private Long product_id;
    @NotNull
    private String size;

} // end class
