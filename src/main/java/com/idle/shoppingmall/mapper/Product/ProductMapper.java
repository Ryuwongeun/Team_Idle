package com.idle.shoppingmall.mapper.Product;


import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.ResponseDTO.Product.ProductCommentListResponse;
import com.idle.shoppingmall.ResponseDTO.Product.ProductListResponse;
import com.idle.shoppingmall.ResponseDTO.Product.ProductSellCountResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper {

    Integer saveProduct(@Param("Product")Product productDTO);

    Product findById(Long productId);

    List<Product> findAllProducts();

    Integer update(@Param("Product") Product productDTO);

    Integer delete(Long product_id);

    // Mapper 인터페이스 메서드에 @Param 어노테이션 추가
    List<Product> findAllProductsPaged(@Param("size") int size, @Param("offset") int offset);

    List<ProductListResponse> findAllByCreatedAtDesc(@Param("size") int size, @Param("offset") int offset);

    List<Product> findAllByPdPriceDown(@Param("size") int size, @Param("offset") int offset);

    List<Product>findAllByLoveCountDesc(@Param("size") int size, @Param("offset") int offset);

    List<ProductSellCountResponse> findAllBySellCountDesc(@Param("size") int size ,@Param("offset") int offset);

    List<Product> findAllByPdName(String searchRequest);



   //제품의 count_love를 증가시키는 메서드
    void increaseLoveCount(@Param("productId")Long productId);
   //제품의 count_love를 감소시키는 메서드
   void decreaseLoveCount(@Param("productId")Long productId);

    List<ProductCommentListResponse> findAllByComment(@Param("offset") int offset, @Param("size") int size);


} // end interface
