package com.idle.shoppingmall.RequestDTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartAddRequest {

    private Long created_who;
    private Long product_id;
    private String size;
    private int count;


} // end class
