package com.idle.shoppingmall.mapper.User;

import com.idle.shoppingmall.Entity.User.User_Account;
import com.idle.shoppingmall.Entity.User.User_Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserInfoMapper {

    User_Info getUserInfoById(@Param("user_id") Long user_id);
}
