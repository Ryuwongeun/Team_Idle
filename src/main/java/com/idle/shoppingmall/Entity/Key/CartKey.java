package com.idle.shoppingmall.Entity.Key;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartKey {
    private Long created_who;
    private Long product_id;
    private String size;
}
