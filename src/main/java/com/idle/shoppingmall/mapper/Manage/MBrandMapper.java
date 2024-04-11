package com.idle.shoppingmall.mapper.Manage;

import com.idle.shoppingmall.ResponseDTO.Manage.MBrandListResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MBrandMapper {
    List<MBrandListResponse> getBrandDetails();
}
