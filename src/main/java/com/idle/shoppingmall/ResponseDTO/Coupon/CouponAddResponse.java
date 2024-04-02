package com.idle.shoppingmall.ResponseDTO.Coupon;

import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CouponAddResponse extends CommonResponse {
    private String coupon_name;

    public CouponAddResponse(int code, String msg, String coupon_name){
        super(code,msg);
        this.coupon_name = coupon_name;
    }
}
