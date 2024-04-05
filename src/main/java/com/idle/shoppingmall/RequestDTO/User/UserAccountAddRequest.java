package com.idle.shoppingmall.RequestDTO.User;

import com.idle.shoppingmall.Entity.User.User_Account;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountAddRequest {
    @NotNull
    private String user_email;
    @NotNull
    private String user_password;
    @NotNull
    private String user_pnum;




}
