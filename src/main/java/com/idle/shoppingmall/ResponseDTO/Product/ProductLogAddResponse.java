package com.idle.shoppingmall.ResponseDTO.Product;

import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ProductLogAddResponse extends CommonResponse {
    private Long product_id;
    private String size;

    public ProductLogAddResponse(int code, String msg, Long product_id, String size) {
        super(code, msg);
        this.product_id = product_id;
        this.size = size;
    }

    public ProductLogAddResponse(int code, String msg,  String size) {
        super(code, msg);
        this.size = size;
    }
}
