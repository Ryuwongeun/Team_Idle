package com.idle.shoppingmall.mapper.Product;

import com.idle.shoppingmall.Entity.Key.DetailKey;
import com.idle.shoppingmall.Entity.Key.ProductKey;
import com.idle.shoppingmall.Entity.Product.ProductDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductDetailMapper {
    void saveProductDetail(@Param("productDetail")ProductDetail productDetailDTO);

    ProductDetail findBySize(@Param("key") DetailKey key);
}
