package com.idle.shoppingmall.mapper.Manage;

import com.idle.shoppingmall.ResponseDTO.Manage.MProductDetailView;
import com.idle.shoppingmall.mapper.Manage.DTO.MProductSortAndOrder;
import com.idle.shoppingmall.ResponseDTO.Manage.MProductListView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MProductMapper {
    List<MProductListView> sortAndSearch(@Param("data") MProductSortAndOrder data);
    List<MProductListView> getList(int paging, int pagingSize);
    MProductDetailView getDetail(Long id);
}

