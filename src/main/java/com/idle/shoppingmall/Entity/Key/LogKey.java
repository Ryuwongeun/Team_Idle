package com.idle.shoppingmall.Entity.Key;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LogKey {
    private Long product_id;
    private Long created_who;
    private String size;
}
