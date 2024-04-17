package com.idle.shoppingmall.Controller.ControllerView.ProductViews;

import com.idle.shoppingmall.Controller.ControllerAPI.Manage.Storage.UploadImages;
import com.idle.shoppingmall.Entity.Comment;
import com.idle.shoppingmall.Entity.User.UserInfo;
import com.idle.shoppingmall.RequestDTO.Comment.CommentAddRequest;
import com.idle.shoppingmall.RequestDTO.Comment.CommentDeleteRequest;
import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import com.idle.shoppingmall.Service.CommentService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class CommentActionController {
    private final CommentService commentService;
    private final UploadImages uploadImg;

    @PostMapping("/api/DELETE/comment")
    public ResponseEntity<CommonResponse> deleteComment(@RequestBody CommentDeleteRequest request, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        if(user == null) return ResponseEntity.ok().body(new CommonResponse(666, "로그인이 필요합니다."));
        if(user.getName() != request.getCreated_who()) return ResponseEntity.ok().body(new CommonResponse(400, "작성자만 댓글을 지울 수 있습니다."));
        Integer result = commentService.deleteComment(request.getCommend_id());
        return ResponseEntity.ok().body(new CommonResponse(200, "삭제가 완료되었습니다."));
    }

    @PostMapping("/api/POST/comment")
    public ResponseEntity<CommonResponse> saveComment(@ModelAttribute CommentAddRequest request, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        if(user == null) return ResponseEntity.ok().body(new CommonResponse(666, "로그인이 필요합니다."));
        Long id = commentService.addComment(request, user.getUser_id(), user.getName());
        uploadImg.commentUploadImages(request.getImages(), id);
        return ResponseEntity.ok().body(new CommonResponse(200, "댓글이 등록되었습니다."));
    }

}
