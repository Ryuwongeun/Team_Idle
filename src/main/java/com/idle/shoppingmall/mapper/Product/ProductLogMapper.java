package com.idle.shoppingmall.mapper.Product;

import com.idle.shoppingmall.Entity.Key.LogKey;
import com.idle.shoppingmall.Entity.Product.ProductLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductLogMapper {
    void saveProductLog(@Param("productLog") ProductLog productLog);

    ProductLog findById(@Param("key") LogKey Key);
}
