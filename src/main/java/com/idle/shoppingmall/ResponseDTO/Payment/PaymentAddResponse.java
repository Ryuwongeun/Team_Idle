package com.idle.shoppingmall.ResponseDTO.Payment;

import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PaymentAddResponse extends CommonResponse {
    private Long created_who;
    private Long product_id;
    private int total_price;
    private String size;



    public PaymentAddResponse(int code, String msg, Long created_who, Long product_id, int total_price, String size) {
        super(code, msg);
        this.created_who = created_who;
        this.product_id = product_id;
        this.total_price = total_price;
        this.size = size;
    }

    public PaymentAddResponse(int code, String msg, Long product_id) {
        super(code, msg);
        this.product_id = product_id;
    }
}
