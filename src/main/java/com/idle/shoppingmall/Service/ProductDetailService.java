package com.idle.shoppingmall.Service;


import com.idle.shoppingmall.Entity.ProductDetail;
import com.idle.shoppingmall.mapper.ProductDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDetailService {
    private final ProductDetailMapper productDetailMapper;

    public void addProductDetail(ProductDetail productDetailDTO) {
        productDetailMapper.saveProductDetail(productDetailDTO);
    }
}
