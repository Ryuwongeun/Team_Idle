package com.idle.shoppingmall.Service.User;

import com.idle.shoppingmall.Entity.User.UserInfo;
import com.idle.shoppingmall.mapper.User.UserInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserInfoService {
    private final UserInfoMapper userInfoMapper;

    public UserInfo getUserInfoById(Long user_id){
        return userInfoMapper.getUserInfoById(user_id);
    }
}
