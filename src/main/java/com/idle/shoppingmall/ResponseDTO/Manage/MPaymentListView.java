package com.idle.shoppingmall.ResponseDTO.Manage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MPaymentListView {
    private Long id;
    private String user_name;
    private String product_name;
    private LocalDateTime created_at;
    private int price;
}
