package com.idle.shoppingmall.ResponseDTO.Product;


import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ProductAddResponse extends CommonResponse {

    private String product_name;

    public ProductAddResponse(int code, String msg, String product_name) {
        super(code, msg);
        this.product_name = product_name;
    } // ProductAddResponse

} // end class
