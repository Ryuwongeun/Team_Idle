package com.idle.shoppingmall.Entity;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

    private Long created_who;

    private Long product_id;

    private String size;

    private int count;

    public void updateCount(int count){
        this.count = count;
    }
} // end class
