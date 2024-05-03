package com.idle.shoppingmall.mapper.User;

import com.idle.shoppingmall.Entity.User.UserLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserLogMapper {
    void insertUserLog(@Param("log") UserLog log);
    String findNickname(@Param("user_id") Long user_id);
}
