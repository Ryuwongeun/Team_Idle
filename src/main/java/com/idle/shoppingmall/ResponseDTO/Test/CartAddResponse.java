package com.idle.shoppingmall.ResponseDTO.Test;


import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CartAddResponse extends CommonResponse {

    private Long product_id;

    public CartAddResponse(int code, String msg, Long product_id) {

        super(code, msg);
        this.product_id = product_id;

    } // Constructor

} // end class
