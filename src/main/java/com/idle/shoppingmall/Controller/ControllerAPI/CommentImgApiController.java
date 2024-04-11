package com.idle.shoppingmall.Controller.ControllerAPI;

import com.idle.shoppingmall.Entity.CommentImg;
import com.idle.shoppingmall.RequestDTO.CommentImgAddRequest;
import com.idle.shoppingmall.ResponseDTO.Comment.CommentImgAddResponse; // 수정된 부분
import com.idle.shoppingmall.Service.CommentImgService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentImgApiController {
    private final CommentImgService commentImgService;

    @PostMapping("/api/POST/addCommentImg")
    public ResponseEntity<CommentImgAddResponse> addCommentImg(@RequestBody @Valid CommentImgAddRequest request){ // 메소드 이름 수정
        if(request.getImg_name() == null || request.getImg_name().trim().isEmpty()){ // null 또는 빈 문자열 체크
            return ResponseEntity.badRequest().body(new CommentImgAddResponse(400,"이미지 이름은 필수입니다.",null));
        }
        Long id = commentImgService.addCommentImg
                (CommentImg.builder()

                        .comment_id(request.getComment_id())
                        .img_url(request.getImg_url())
                        .img_name(request.getImg_name())
                        .build()
                );
        if(id == null){
            return ResponseEntity.badRequest().body(new CommentImgAddResponse(400,"이미지 추가 실패",null));
        }
        return ResponseEntity.ok().body(new CommentImgAddResponse(200,"성공", request.getImg_name()));
    }
}
