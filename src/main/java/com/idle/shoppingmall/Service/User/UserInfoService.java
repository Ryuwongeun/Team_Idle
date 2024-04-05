package com.idle.shoppingmall.Service.User;

import com.idle.shoppingmall.Entity.User.User_Info;
import com.idle.shoppingmall.mapper.User.UserInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserInfoService {
    private final UserInfoMapper userInfoMapper;

    public User_Info getUserInfoById(Long user_id){
        return userInfoMapper.getUserInfoById(user_id);
    }

    public int addUser_Info(User_Info userInfoDTO) {
        return userInfoMapper.addUser_Info(userInfoDTO);

    }

}
