package com.idle.shoppingmall.ResponseDTO.Test;

import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TestListResponse extends CommonResponse {
    private String id;
    private String name;
    private int index;

    public TestListResponse(int code, String msg, int index, String id, String name) {
        super(code, msg);
        this.index = index;
        this.id = id;
        this.name = name;
    }
}
