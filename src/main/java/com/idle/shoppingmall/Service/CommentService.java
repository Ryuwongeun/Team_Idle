package com.idle.shoppingmall.Service;

import com.idle.shoppingmall.Entity.Comment;
import com.idle.shoppingmall.mapper.CommentMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentMapper commentMapper;

    @Transactional
    public Long addComment(Comment comment){
        return commentMapper.saveComment(comment);
    }

}
