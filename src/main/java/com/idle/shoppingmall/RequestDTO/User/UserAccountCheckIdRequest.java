package com.idle.shoppingmall.RequestDTO.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserAccountCheckIdRequest {
    private String user_email;
}
