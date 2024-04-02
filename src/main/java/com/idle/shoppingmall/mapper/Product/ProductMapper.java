package com.idle.shoppingmall.mapper.Product;


import com.idle.shoppingmall.Entity.Product.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper {

    Long saveProduct(@Param("product")Product productDTO);

    Product findById(Long productId);
    List<Product> findAllProducts();
} // end interface
