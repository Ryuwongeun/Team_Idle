package com.idle.shoppingmall.mapper.Comment;

import com.idle.shoppingmall.Entity.CommentImg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentImgMapper {

    Long saveCommentImg(@Param("list") List<CommentImg> list);
}
