package com.idle.shoppingmall.Service;

import com.idle.shoppingmall.Entity.User.User_Account;
import com.idle.shoppingmall.Entity.User.User_Info;
import com.idle.shoppingmall.mapper.User.UserAccountMapper;
import com.idle.shoppingmall.mapper.User.UserInfoMapper;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserAccountMapper userAccountMapper;
    private final UserInfoMapper userInfoMapper;

    @Transactional
    public void setSession(String email, HttpSession session){
        User_Account account = userAccountMapper.getUserByEmail(email);
        Long id = account.getUser_id();
        User_Info user = userInfoMapper.getUserInfoById(id);
        if(user==null){
            return;
        }
        userAccountMapper.updateLastLogin(id);
        session.setAttribute("user", user);
        session.setMaxInactiveInterval(60*60*24*30);
    }
}
