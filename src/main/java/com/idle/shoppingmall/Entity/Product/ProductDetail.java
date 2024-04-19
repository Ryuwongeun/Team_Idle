package com.idle.shoppingmall.Entity.Product;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDetail {
    private Long product_id;
    private String size;
    private int product_before_count;
    private int product_sell_count;

    public void updateCount(int count){
        this.product_before_count +=count;
    }
} // end class
