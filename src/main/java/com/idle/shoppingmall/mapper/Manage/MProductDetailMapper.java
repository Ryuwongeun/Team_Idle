package com.idle.shoppingmall.mapper.Manage;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MProductDetailMapper {
    Integer addCountProductDetail(String size, int count);
}
