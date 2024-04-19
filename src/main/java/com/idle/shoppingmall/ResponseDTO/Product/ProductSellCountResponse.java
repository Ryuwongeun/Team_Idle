package com.idle.shoppingmall.ResponseDTO.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ProductSellCountResponse  {
    private Long product_id;
    private String product_name;
    private int product_price;
    private String product_category;
    private Long created_who;
    private LocalDateTime created_at;
    private int count_love;
    private int pd_sell_count;

    public ProductSellCountResponse (Long product_id, String product_name, int product_price, String product_category, Long created_who, LocalDateTime created_at, int count_love, int pd_sell_count) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_category = product_category;
        this.created_who = created_who;
        this.created_at = created_at;
        this.count_love = count_love;
        this.pd_sell_count=pd_sell_count;
    }
}
