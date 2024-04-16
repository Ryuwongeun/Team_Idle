package com.idle.shoppingmall.Controller.ControllerAPI;

import com.idle.shoppingmall.Entity.Comment;
import com.idle.shoppingmall.RequestDTO.Comment.CommentAddRequest;
import com.idle.shoppingmall.ResponseDTO.Comment.CommentAddResponse;
import com.idle.shoppingmall.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class CommentApiController {
    private final CommentService commentService;

//    @PostMapping("/api/POST/addComment")
//    public ResponseEntity<CommentAddResponse> addComment(@RequestBody CommentAddRequest request){
//        if(request.getCreated_who()==null){
//            return ResponseEntity.ok().body(new CommentAddResponse(400,"xx",null));
//        }
//
//        Long id = commentService.addComment
//                (Comment.builder()
//                        .created_who(request.getCreated_who())
//                        .product_id(request.getProduct_id())
//                        .content(request.getContent())
//                        .created_at(LocalDateTime.now())
//                        .build()
//                );
//            if(id==null){
//                return ResponseEntity.ok().body(new CommentAddResponse(400,"실패",null));
//            }
//            return ResponseEntity.ok().body(new CommentAddResponse(200,"성공", request.getCreated_who()));
//    }
}
