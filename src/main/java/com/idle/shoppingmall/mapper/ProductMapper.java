package com.idle.shoppingmall.mapper;


import com.idle.shoppingmall.Entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper {

    void saveProduct(@Param("product")Product productDTO);

    List<Product> findAllProducts();
} // end interface
