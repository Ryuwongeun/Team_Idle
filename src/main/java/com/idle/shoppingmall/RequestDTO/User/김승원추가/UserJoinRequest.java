package com.idle.shoppingmall.RequestDTO.User.김승원추가;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserJoinRequest {
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String pnum;
    @NotNull
    private String name;
}
