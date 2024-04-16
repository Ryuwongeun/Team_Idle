package com.idle.shoppingmall.RequestDTO.Comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentAddRequest {
    private Long product_id;
    private String content;
    private List<MultipartFile> images;
}
