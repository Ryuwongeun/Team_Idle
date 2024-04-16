package com.idle.shoppingmall.RequestDTO.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDeleteRequest {
    private Long commend_id;
    private String created_who;
}
