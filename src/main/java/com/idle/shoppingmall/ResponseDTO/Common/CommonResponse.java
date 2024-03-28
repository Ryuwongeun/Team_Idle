package com.idle.shoppingmall.ResponseDTO.Common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CommonResponse {
    private int code;
    private String msg;
}
