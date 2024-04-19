package com.idle.shoppingmall.mapper.Payment;

import com.idle.shoppingmall.ResponseDTO.Order.OrderListViewResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PayLogManageMapper {
    List<OrderListViewResponse> UserFindOrderList(@Param("created_who")Long created_who, @Param("size") int size, @Param("offset") int offset);
}
