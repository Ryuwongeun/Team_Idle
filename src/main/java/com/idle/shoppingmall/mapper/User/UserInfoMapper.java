package com.idle.shoppingmall.mapper.User;

import com.idle.shoppingmall.Entity.User.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserInfoMapper {

    UserInfo getUserInfoById(@Param("user_id") Long user_id);

    int addUser_Info(@Param("add")UserInfo userInfoDTO);

    UserInfo getUserInfoByName(@Param("name") String name);
}
