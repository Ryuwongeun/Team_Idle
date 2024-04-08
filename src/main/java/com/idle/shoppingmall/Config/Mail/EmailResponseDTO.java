package com.idle.shoppingmall.Config.Mail;

import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.Getter;

@Getter
public class EmailResponseDTO extends CommonResponse {

    private final String data;

    public EmailResponseDTO(int code, String msg, String data){
        super(code, msg);
        this.data = data;
    }
}
