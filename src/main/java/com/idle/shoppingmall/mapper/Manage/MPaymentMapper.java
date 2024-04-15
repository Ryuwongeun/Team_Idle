package com.idle.shoppingmall.mapper.Manage;

import com.idle.shoppingmall.ResponseDTO.Manage.PaymentListResponse;
import com.idle.shoppingmall.mapper.Manage.DTO.MPaymentSortAndOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MPaymentMapper {
    List<PaymentListResponse> getPaymentList(@Param("data") MPaymentSortAndOrder data);
}
