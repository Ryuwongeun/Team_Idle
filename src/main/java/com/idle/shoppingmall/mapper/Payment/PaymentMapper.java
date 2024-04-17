package com.idle.shoppingmall.mapper.Payment;

import com.idle.shoppingmall.Entity.Delivery;
import com.idle.shoppingmall.Entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PaymentMapper {
    Long savePayment(@Param("payment") Payment payment);

    Payment findById(Long paymentId);

    Integer delete(Long paymentId);

    Integer setPayment(@Param("list")List<Payment> list);

    Integer setDelivery(@Param("data")Delivery data);
}
