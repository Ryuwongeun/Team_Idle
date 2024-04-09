package com.idle.shoppingmall.ResponseDTO.Product;

import com.idle.shoppingmall.Entity.Brand;
import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BrandListResponse {
    private Long brand_id;
    private String brand_name;
}
