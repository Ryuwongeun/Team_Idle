package com.idle.shoppingmall.Controller.ControllerAPI;

import com.idle.shoppingmall.Controller.ControllerAPI.Manage.Storage.UploadImages;
import com.idle.shoppingmall.Entity.Comment;
import com.idle.shoppingmall.Entity.User.UserInfo;
import com.idle.shoppingmall.RequestDTO.Comment.CommentAddRequest;
import com.idle.shoppingmall.RequestDTO.Comment.CommentDeleteRequest;
import com.idle.shoppingmall.ResponseDTO.Comment.CommentAddResponse;
import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import com.idle.shoppingmall.Service.CommentService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class CommentApiController {
    private final CommentService commentService;
    private final UploadImages uploadImg;

    @PostMapping("/api/DELETE/comment")
    public ResponseEntity<CommonResponse> deleteComment(@RequestBody CommentDeleteRequest request, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        if(user == null) return ResponseEntity.ok().body(new CommonResponse(666, "로그인이 필요합니다."));
        System.out.println("request : "+request.getCreated_who());
        System.out.println("user : "+user.getName());
        System.out.println("ID : "+request.getComment_id());
        if(!user.getName().equals(request.getCreated_who())) return ResponseEntity.ok().body(new CommonResponse(400, "작성자만 댓글을 지울 수 있습니다."));
        Integer result = commentService.deleteComment(request.getComment_id());

        return result==null ? ResponseEntity.ok().body(new CommonResponse(500, "삭제에 실패했습니다..")) :
                ResponseEntity.ok().body(new CommonResponse(200, "삭제가 완료되었습니다."));
    }

    @PostMapping("/api/POST/comment")
    public ResponseEntity<CommonResponse> saveComment(@ModelAttribute @Valid CommentAddRequest request, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        if(user == null) return ResponseEntity.ok().body(new CommonResponse(666, "로그인이 필요합니다."));
        if(request.getContent().length()==0) return ResponseEntity.ok().body(new CommonResponse(400, "댓글의 내용을 입력해주세요."));
        Long id = commentService.addComment(request, user.getUser_id(), user.getName());
        uploadImg.commentUploadImages(request.getImages(), id);
        return ResponseEntity.ok().body(new CommonResponse(200, "댓글이 등록되었습니다."));
    }

}
