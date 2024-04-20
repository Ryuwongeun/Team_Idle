package com.idle.shoppingmall.mapper.Manage.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSortRequest {
    private int id;
    private String name;
    private int page;
}

