package com.idle.shoppingmall.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment_img {
    private Long img_id;
    private Long comment_id;
    private String img_url;
    private String img_name;
}
