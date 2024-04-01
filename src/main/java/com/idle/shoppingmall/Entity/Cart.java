package com.idle.shoppingmall.Entity;


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

} // end class
