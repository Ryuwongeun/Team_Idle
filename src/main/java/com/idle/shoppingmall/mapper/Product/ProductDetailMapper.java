package com.idle.shoppingmall.mapper.Product;

import com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO.SalesDTO;
import com.idle.shoppingmall.Entity.Key.DetailKey;
import com.idle.shoppingmall.Entity.Product.ProductDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductDetailMapper {
    Integer saveProductDetail(@Param("productDetail")ProductDetail productDetailDTO);

    ProductDetail findBySize(@Param("key") DetailKey key);

    Integer update(@Param("Product")ProductDetail detail);

    Integer sales(@Param("payment") SalesDTO payment);
}
