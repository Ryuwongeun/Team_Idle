package com.idle.shoppingmall.RequestDTO.Cart;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartListRequest {
    @NotNull
    private Long created_who;
}
