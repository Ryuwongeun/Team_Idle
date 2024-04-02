package com.idle.shoppingmall.Service.product;


import com.idle.shoppingmall.Entity.Key.DetailKey;
import com.idle.shoppingmall.Entity.Product.ProductDetail;
import com.idle.shoppingmall.mapper.Product.ProductDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDetailService {
    private final ProductDetailMapper productDetailMapper;

    public void addProductDetail(ProductDetail productDetailDTO) {
        productDetailMapper.saveProductDetail(productDetailDTO);
    }

    public ProductDetail findDetail(Long productId, String size) {
        return productDetailMapper.findBySize(new DetailKey(productId, size));
    }
}
