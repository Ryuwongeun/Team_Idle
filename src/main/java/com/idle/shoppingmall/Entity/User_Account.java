package com.idle.shoppingmall.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class User_Account {
    private Long user_id;
    private String user_email;
    private String user_password;
    private String user_pnum;
    private UserRole user_role;
    private LocalDateTime last_login;

    public enum UserRole {
        USER, MANAGER, ADMIN
    }
    @Builder
    public User_Account(String user_email, String user_password, UserRole user_role, String user_pnum, LocalDateTime last_login) {
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_role = user_role;
        this.user_pnum= user_pnum;
        this.last_login = last_login;
    }
}