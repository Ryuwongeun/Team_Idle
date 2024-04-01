package com.idle.shoppingmall.mapper;


import com.idle.shoppingmall.Entity.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CartMapper {

    void saveCart(@Param("cart")Cart cartDTO);


} // interface
