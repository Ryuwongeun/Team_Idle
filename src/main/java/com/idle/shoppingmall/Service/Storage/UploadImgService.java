package com.idle.shoppingmall.Service.Storage;

import com.idle.shoppingmall.Entity.CommentImg;
import com.idle.shoppingmall.Entity.Product.ProductImg;
import com.idle.shoppingmall.mapper.Comment.CommentImgMapper;
import com.idle.shoppingmall.mapper.Product.ProductImgMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UploadImgService {

    private final ProductImgMapper mapper;
    private final CommentImgMapper commentImgMapper;

    @Transactional
    public void upload(List<ProductImg> imgList) {
        mapper.saveProductImg(imgList);
    }

    @Transactional
    public void uploadCommentImg(List<CommentImg> imgList) {
        commentImgMapper.saveCommentImg(imgList);
    }
}
