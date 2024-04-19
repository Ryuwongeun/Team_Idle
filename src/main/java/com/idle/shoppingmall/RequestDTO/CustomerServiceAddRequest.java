package com.idle.shoppingmall.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerServiceAddRequest {
    private String user_name;
    private Long payment_id;
    private String content;
}
