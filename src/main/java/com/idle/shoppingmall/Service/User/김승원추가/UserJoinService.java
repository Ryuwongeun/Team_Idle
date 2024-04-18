package com.idle.shoppingmall.Service.User.김승원추가;


import com.idle.shoppingmall.Entity.User.UserAccount;
import com.idle.shoppingmall.Entity.User.UserInfo;
import com.idle.shoppingmall.RequestDTO.User.김승원추가.UserJoinRequest;
import com.idle.shoppingmall.mapper.User.UserAccountMapper;
import com.idle.shoppingmall.mapper.User.UserInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserJoinService {
    private final UserInfoMapper userInfoMapper;
    private final UserAccountMapper userAccountMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public UserInfo getUserInfoByName(String name){
        return userInfoMapper.getUserInfoByName(name);
    }

    @Transactional(readOnly = true)
    public UserAccount getUserAccountByEmail(String email){
        return userAccountMapper.getUserByEmail(email);
    }

    @Transactional
    public Integer joinUser(UserJoinRequest request){
        UserAccount user = UserAccount.builder()
                .user_email(request.getEmail())
                .user_password(passwordEncoder.encode(request.getPassword()))
                .user_pnum(request.getPnum())
                .user_role(UserAccount.UserRole.USER)
                .last_login(LocalDateTime.now())
                .build();
        System.out.println("111111111111111111111111");
        userAccountMapper.saveUserAccount(user);
        System.out.println("2222222222222222222222222222");
        Integer id = userInfoMapper.addUser_Info(UserInfo.builder()
                .user_id(user.getUser_id())
                .name(request.getName())
                .build());
        System.out.println("333333333333333333333333333333333");
        return id;
    }
}
