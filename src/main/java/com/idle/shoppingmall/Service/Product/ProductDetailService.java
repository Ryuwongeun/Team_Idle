package com.idle.shoppingmall.Service.Product;


import com.idle.shoppingmall.Entity.Key.DetailKey;
import com.idle.shoppingmall.Entity.Product.ProductDetail;
import com.idle.shoppingmall.mapper.Product.ProductDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductDetailService {
    private final ProductDetailMapper productDetailMapper;

    public Integer addProductDetail(ProductDetail productDetailDTO) {
        return productDetailMapper.saveProductDetail(productDetailDTO);
    }

    public ProductDetail findDetail(Long product_id, String size) {
        return productDetailMapper.findBySize(new DetailKey(product_id, size));
    }

    public Integer updateProductDetail(ProductDetail productDetail){
        return productDetailMapper.update(productDetail);
    }


}
