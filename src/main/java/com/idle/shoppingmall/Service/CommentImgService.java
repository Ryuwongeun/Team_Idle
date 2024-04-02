package com.idle.shoppingmall.Service;

import com.idle.shoppingmall.Entity.Comment_img;
import com.idle.shoppingmall.mapper.CommentImgMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentImgService {
    private final CommentImgMapper commentImgMapper;

    @Transactional
    public Long addCommentImg(Comment_img commentImg){
        return commentImgMapper.saveCommentImg(commentImg);
    }
}
