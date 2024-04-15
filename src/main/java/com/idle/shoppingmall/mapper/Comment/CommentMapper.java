package com.idle.shoppingmall.mapper.Comment;

import com.idle.shoppingmall.Entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {

    Long saveComment(@Param("comment") Comment comment);
}
