package com.idle.shoppingmall.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentAddRequest {
    private Long created_who;
    private Long product_id;
    private String content;
    private LocalDateTime created_at;

}
