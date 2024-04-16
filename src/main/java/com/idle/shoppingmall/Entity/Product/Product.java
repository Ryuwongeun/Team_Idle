package com.idle.shoppingmall.Entity.Product;


import com.idle.shoppingmall.Entity.Brand;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private String pd_name;
    private int pd_price;
    private String pd_category;
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
