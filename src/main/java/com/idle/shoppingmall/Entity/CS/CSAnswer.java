package com.idle.shoppingmall.Entity.CS;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CSAnswer {
    private Long cs_id;
    private String content;
    private Long created_who;
    private LocalDateTime created_at;
}
