package com.idle.shoppingmall.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserLog {
    private Long userlog_id;
    private Long created_who;
    private String name;
    private LocalDateTime created_at;
    private String doit;
    private Long product_id;
}
