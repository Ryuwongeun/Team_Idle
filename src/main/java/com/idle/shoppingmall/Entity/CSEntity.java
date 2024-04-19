package com.idle.shoppingmall.Entity;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CSEntity {
    private Long cs_id;
    private Long created_who;
    private Long payment_id;
    private String content;
    private String state;
    private LocalDateTime created_at;
}
