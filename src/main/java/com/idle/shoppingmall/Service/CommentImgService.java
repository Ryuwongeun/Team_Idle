package com.idle.shoppingmall.Service;

import com.idle.shoppingmall.Entity.CommentImg;
import com.idle.shoppingmall.mapper.CommentImgMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentImgService {
    private final CommentImgMapper commentImgMapper;

    @Transactional
    public Long addCommentImg(CommentImg commentImg){
        return commentImgMapper.saveCommentImg(commentImg);
    }
}
