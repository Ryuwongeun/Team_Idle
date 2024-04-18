package com.idle.shoppingmall.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {
    private Long delivery_id;
    private String tg_pnum;
    private String address;
    private String state;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
