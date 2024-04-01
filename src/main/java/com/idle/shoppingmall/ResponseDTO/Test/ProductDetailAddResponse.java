package com.idle.shoppingmall.ResponseDTO.Test;

import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ProductDetailAddResponse extends CommonResponse {
    private Long product_id;
    private String size;
    private int pd_sell_count;

    public ProductDetailAddResponse(int code, String msg, Long product_id) {
        super(code, msg);
        this.product_id = product_id;
    }

    public ProductDetailAddResponse(int code, String msg, String size) {
        super(code, msg);
        this.size = size;
    }

    public ProductDetailAddResponse(int code, String msg, int pd_sell_count) {
        super(code, msg);
        this.pd_sell_count = pd_sell_count;
    }

    public ProductDetailAddResponse(int code, String msg, Long product_id, String size, int pd_sell_count) {
        super(code, msg);
        this.product_id = product_id;
        this.size = size;
        this.pd_sell_count = pd_sell_count;
    }
}