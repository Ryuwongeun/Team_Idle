package com.idle.shoppingmall.Entity.Product;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    private Long product_id;
    private Long brand_id;
    private Long created_who;
    private LocalDateTime created_at;
    private String product_name;
    private int product_price;
    private String product_category;
    private int count_love;
    private String product_img;

    public void increaseLoveCount(){
        this.count_love +=1;
    }

    public void decreaseLoveCount(){
        if(this.count_love >0){
            this.count_love -=1;
        }
    }

} // end class
