package com.idle.shoppingmall.mapper;

import com.idle.shoppingmall.Entity.Brand;
import com.idle.shoppingmall.ResponseDTO.Product.BrandListResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BrandMapper {
    List<BrandListResponse> findByName(String brand_name, @Param("size") int size,@Param("offset") int offset);

    List<BrandListResponse> findAll(@Param("size") int size,@Param("offset") int offset);
}
