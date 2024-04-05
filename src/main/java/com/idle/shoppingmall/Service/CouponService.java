package com.idle.shoppingmall.Service;

import com.idle.shoppingmall.Entity.Coupon;
import com.idle.shoppingmall.mapper.CouponMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponMapper couponMapper;

    @Transactional
    public Long addCoupon(Coupon coupon){
        return couponMapper.saveCoupon(coupon);
    }
}
