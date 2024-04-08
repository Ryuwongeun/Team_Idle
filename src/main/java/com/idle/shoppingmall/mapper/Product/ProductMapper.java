package com.idle.shoppingmall.mapper.Product;


import com.idle.shoppingmall.Entity.Product.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper {

    Long saveProduct(@Param("Product")Product productDTO);

    Product findById(Long productId);
    List<Product> findAllProducts();

    Integer update(@Param("Product") Product productDTO);

    Integer delete(Long product_id);

    // Mapper 인터페이스 메서드에 @Param 어노테이션 추가
    List<Product> findAllProductsPaged(@Param("size") int size, @Param("offset") int offset);

    List<Product> findAllByCreatedAtDesc();

    List<Product> findAllByPdPriceDescUp();

    List<Product> findAllByPdPriceDescDown();

    List<Product>findAllByLoveCountDesc();

   //제품의 count_love를 증가시키는 메서드
    void increaseLoveCount(@Param("productId")Long productId);
   //제품의 count_love를 감소시키는 메서드
   void decreaseLoveCount(@Param("productId")Long productId);



} // end interface
