package com.idle.shoppingmall.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}



