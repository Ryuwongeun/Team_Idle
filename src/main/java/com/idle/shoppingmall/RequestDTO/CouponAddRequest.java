package com.idle.shoppingmall.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CouponAddRequest {
    private String coupon_name; // 쿠폰 이름
    private Byte discount_size; // 쿠폰 할인율
    private Long brand_id; // 해당 쿠폰과 연결된 브랜드 ID
    private Long created_who; // 쿠폰을 생성한 사용자의 ID
    private LocalDateTime created_at; // 쿠폰이 생성된 날짜 및 시간
    private Integer discount_price; // 쿠폰 사용 시 제공되는 할인금액
    private Long product_id; // 쿠폰이 적용될 수 있는 상품 ID

}
