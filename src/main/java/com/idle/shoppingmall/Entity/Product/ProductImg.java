package com.idle.shoppingmall.Entity.Product;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductImg {
    private Long img_id;
    private Long product_id;
    private String img_url;
    private String img_name;
    private Long created_who;
    private LocalDateTime created_at;
}
