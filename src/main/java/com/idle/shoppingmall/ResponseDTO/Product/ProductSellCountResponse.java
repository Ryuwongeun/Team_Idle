package com.idle.shoppingmall.ResponseDTO.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ProductSellCountResponse  {
    private Long product_id;
    private String pd_name;
    private int pd_price;
    private String pd_category;
    private Long created_who;
    private LocalDateTime created_at;
    private int count_love;
    private int pd_sell_count;

    public ProductSellCountResponse (Long product_id, String pd_name, int pd_price, String pd_category, Long created_who, LocalDateTime created_at, int count_love, int pd_sell_count) {
        this.product_id = product_id;
        this.pd_name = pd_name;
        this.pd_price = pd_price;
        this.pd_category = pd_category;
        this.created_who = created_who;
        this.created_at = created_at;
        this.count_love = count_love;
        this.pd_sell_count=pd_sell_count;
    }
}
