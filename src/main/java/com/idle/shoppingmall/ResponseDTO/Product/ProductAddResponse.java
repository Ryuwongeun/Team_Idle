package com.idle.shoppingmall.ResponseDTO.Product;


import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ProductAddResponse extends CommonResponse {

    private String pd_name;

    public ProductAddResponse(int code, String msg, String pd_name) {
        super(code, msg);
        this.pd_name = pd_name;
    } // ProductAddResponse

} // end class
