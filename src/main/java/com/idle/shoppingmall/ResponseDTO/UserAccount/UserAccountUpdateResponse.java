package com.idle.shoppingmall.ResponseDTO.UserAccount;

import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserAccountUpdateResponse extends CommonResponse {
    private Long user_id;

    public UserAccountUpdateResponse (int code,String msg,Long user_id){
        super(code,msg);
        this.user_id=user_id;
    }
}
