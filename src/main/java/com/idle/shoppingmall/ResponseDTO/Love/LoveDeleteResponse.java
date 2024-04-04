package com.idle.shoppingmall.ResponseDTO.Love;


import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LoveDeleteResponse extends CommonResponse {

    private Long product_id;

    public LoveDeleteResponse(int code, String msg, Long product_id) {
        super(code, msg);
        this.product_id = product_id;
    } // LoveAddResponse

} // end class
