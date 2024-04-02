package com.idle.shoppingmall.mapper;

import com.idle.shoppingmall.Entity.Coupon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CouponMapper {
    Long saveCoupon(@Param("coupon")Coupon coupon);
}
