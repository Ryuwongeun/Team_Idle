package com.idle.shoppingmall.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coupon {

    private Long coupon_id; //쿠폰의 고유 ID
    private Boolean used; //쿠폰 사용여부
    private String coupon_name; //쿠폰 이름
    private Byte discount_size; //쿠폰 할인율
    private Long brand_id; //해당 쿠폰과 연견된 브랜드 ID
    private Long created_who; //쿠폰을 생성한 사용자의 ID
    private LocalDateTime created_at; //쿠폰이 생성된 날짜 및 시간
    private LocalDateTime used_at;  //쿠폰이 사용된 날짜 및 시간
    private Integer discount_price; //쿠폰 사용시 제공되는 할인금액
    private Long product_id; //쿠폰이 적용될 수 있는 상품 ID
}
