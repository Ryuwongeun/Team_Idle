package com.idle.shoppingmall.ControllerAPI;

import com.idle.shoppingmall.Entity.Coupon;
import com.idle.shoppingmall.RequestDTO.CouponAddRequest;
import com.idle.shoppingmall.ResponseDTO.Coupon.CouponAddResponse;
import com.idle.shoppingmall.Service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class CouponController {
    private final CouponService couponService;

    @PostMapping("/api/POST/addCoupon")
    public ResponseEntity<CouponAddResponse> addCoupon(@RequestBody CouponAddRequest request){
        if(request.getCoupon_name()==null){
            return ResponseEntity.ok().body(new CouponAddResponse(400,"XX",null));
        }
        Long id= couponService.addCoupon
            (Coupon.builder()
                    .coupon_name(request.getCoupon_name())
                    .discount_size(request.getDiscount_size())
                    .brand_id(request.getBrand_id())
                    .created_who(request.getCreated_who())
                    .created_at(LocalDateTime.now())
                    .discount_price(request.getDiscount_price())
                    .used_at(LocalDateTime.now())
                    .product_id(request.getProduct_id())

                    .build()

            );
        if(id==null){
            return ResponseEntity.ok().body(new CouponAddResponse(400,"실패",null));

        }

        return ResponseEntity.ok().body(new CouponAddResponse(200,"성공",request.getCoupon_name()));
    }


}
