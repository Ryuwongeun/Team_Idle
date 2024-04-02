package com.idle.shoppingmall.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentImgAddRequest {
    private Long img_id;
    private Long comment_id;
    private String img_url;
    private String img_name;
}
