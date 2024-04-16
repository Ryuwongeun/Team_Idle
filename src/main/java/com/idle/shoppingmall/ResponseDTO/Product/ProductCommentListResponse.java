package com.idle.shoppingmall.ResponseDTO.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ProductCommentListResponse {
    private Long product_id;
    private String pd_name;
    private int pd_price;
    private String pd_category;
    private int count_love;
    private int comment_count;

    public ProductCommentListResponse(Long product_id,
                                      String pd_name,
                                      int pd_price,
                                      String pd_category,
                                      int count_love,
                                      int comment_count) {
        this.product_id = product_id;
        this.pd_name = pd_name;
        this.pd_price = pd_price;
        this.pd_category = pd_category;
        this.count_love = count_love;
        this.comment_count = comment_count;
    }
}
