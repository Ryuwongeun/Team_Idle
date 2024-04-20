package com.idle.shoppingmall.RequestDTO.CustomerService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CSAnswerRequest {
    private Long cs_id;
    private String content;
    private String state;
}
