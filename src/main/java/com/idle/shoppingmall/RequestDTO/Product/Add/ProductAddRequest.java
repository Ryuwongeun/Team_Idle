package com.idle.shoppingmall.RequestDTO.Product.Add;


import com.idle.shoppingmall.mapper.Manage.DTO.SizeAndCount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductAddRequest {
    private String pd_name;
    private Long brand;
    private int pd_price;
    private String pd_category;
    private List<SizeAndCount> sizes;
}

