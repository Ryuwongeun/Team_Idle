package com.idle.shoppingmall.mapper.Manage.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddCountProductDetailRequest {
    private Long id;
    private String size;
    private int count;
}
