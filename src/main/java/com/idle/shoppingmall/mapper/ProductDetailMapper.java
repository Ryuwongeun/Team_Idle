package com.idle.shoppingmall.mapper;

import com.idle.shoppingmall.Entity.ProductDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductDetailMapper {
    void saveProductDetail(@Param("productDetail")ProductDetail productDetailDTO);
}
