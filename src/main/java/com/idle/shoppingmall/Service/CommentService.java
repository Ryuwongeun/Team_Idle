package com.idle.shoppingmall.Service;

import com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO.CommentListResponse;
import com.idle.shoppingmall.Entity.Comment;
import com.idle.shoppingmall.RequestDTO.Comment.CommentAddRequest;
import com.idle.shoppingmall.Service.User.UserInfoService;
import com.idle.shoppingmall.mapper.Comment.CommentMapper;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentMapper commentMapper;
    private final UserInfoService userInfoService;

    @Transactional
    public Long addComment(CommentAddRequest request, Long id){
        Comment comment = Comment.builder()
                .created_who(id)
                .product_id(request.getProduct_id())
                .content(request.getContent())
                .created_at(LocalDateTime.now())
                .build();
        commentMapper.saveComment(comment);
        return comment.getComment_id();
    }

    @Transactional(readOnly = true)
    public List<CommentListResponse> findCommentList(Long id ,int startpage, int endpage) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<Comment> comments = commentMapper.findCommentList(id, startpage, endpage);
        System.out.println(commentMapper.findUrl(comments.get(0).getComment_id()));
        List<CommentListResponse> commentList = comments.stream()
                .map(data -> new CommentListResponse(
                        data.getComment_id(),
                        userInfoService.getUserInfoById(data.getCreated_who()).getName(),
                        data.getContent(),
                        data.getCreated_at().format(formatter),
                        commentMapper.findUrl(data.getComment_id())
                ))
                .toList();
        return commentList;
    }

    @Transactional
    public Integer deleteComment(Long id){
        return commentMapper.deleteComment(id);
    }

}
