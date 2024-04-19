package com.idle.shoppingmall.ResponseDTO.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductCommentListResponse {
    private Long product_id;
    private String product_name;
    private int product_price;
    private String product_category;
    private int count_love;
    private int comment_count;

    public ProductCommentListResponse(Long product_id,
                                      String product_name,
                                      int product_price,
                                      String product_category,
                                      int count_love,
                                      int comment_count) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_category = product_category;
        this.count_love = count_love;
        this.comment_count = comment_count;
    }
}
