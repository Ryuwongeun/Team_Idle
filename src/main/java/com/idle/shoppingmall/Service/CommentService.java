package com.idle.shoppingmall.Service;

import com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO.CommentListResponse;
import com.idle.shoppingmall.Entity.Comment;
import com.idle.shoppingmall.RequestDTO.Comment.CommentAddRequest;
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

    @Transactional
    public Long addComment(CommentAddRequest request, Long id, String name){
        Comment comment = Comment.builder()
                .created_who(id)
                .product_id(request.getProduct_id())
                .content(request.getContent())
                .created_at(LocalDateTime.now())
                .created_name(name)
                .build();
        commentMapper.saveComment(comment);
        return comment.getComment_id();
    }

    @Transactional(readOnly = true)
    public List<CommentListResponse> findCommentList(Long id ,int startpage, int endpage) {
        return commentMapper.findCommentList(id, startpage, endpage);
//        System.out.println(comments.size());
//        if(comments.isEmpty()) return null;
//
//        System.out.println(commentMapper.findUrl(comments.get(0).getComment_id()));
//        List<CommentListResponse> commentList = comments.stream()
//                .map(data -> new CommentListResponse(
//                        data.getComment_id(),
//                        data.getCreated_name(),
//                        data.getContent(),
//                        data.getCreated_at().format(formatter),
//                        commentMapper.findUrl(data.getComment_id())
//                ))
//                .toList();
//        return commentList;
    }

    @Transactional
    public Integer deleteComment(Long id){
        return commentMapper.deleteComment(id);
    }

}
