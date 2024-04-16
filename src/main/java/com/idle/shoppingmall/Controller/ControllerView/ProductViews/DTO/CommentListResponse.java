package com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentListResponse {
    private Long id;
    private String name;
    private String content;
    private String created_at;
    private List<String> url;
}