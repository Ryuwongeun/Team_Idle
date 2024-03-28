package com.idle.shoppingmall.ResponseDTO.Test;

import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TestAddResponse extends CommonResponse {

    private String name;

    public TestAddResponse(int code, String msg, String name) {
        super(code, msg);
        this.name = name;
    }

}
