package com.idle.shoppingmall.RequestDTO;

import com.idle.shoppingmall.Entity.User_Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountAddRequest {
    private String user_email;
    private String user_password;
    private String user_pnum;
    private User_Account.UserRole user_role;


}
