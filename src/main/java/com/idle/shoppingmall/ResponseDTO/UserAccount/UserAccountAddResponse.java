package com.idle.shoppingmall.ResponseDTO.UserAccount;

import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserAccountAddResponse extends CommonResponse {
    private String user_email;

    public UserAccountAddResponse(int code, String msg, String user_email){
        super(code,msg);
        this.user_email = user_email;
    }
}
