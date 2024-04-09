package com.idle.shoppingmall.Service;

import com.idle.shoppingmall.Entity.Comment;
import com.idle.shoppingmall.mapper.Comment.CommentMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentMapper commentMapper;

    @Transactional
    public Long addComment(Comment comment){
        return commentMapper.saveComment(comment);
    }

    public List<Comment> findAllByComment() {
        return commentMapper.findAllByComment();
    }
}
