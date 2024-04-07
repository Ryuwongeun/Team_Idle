package com.idle.shoppingmall.Config.OAuth2;

import com.idle.shoppingmall.Entity.User.UserAccount;
import com.idle.shoppingmall.Entity.User.UserInfo;
import com.idle.shoppingmall.Service.LoginService;
import com.idle.shoppingmall.mapper.User.UserAccountMapper;
import com.idle.shoppingmall.mapper.User.UserInfoMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@RequiredArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {
    private final LoginService loginService;
    private final UserAccountMapper userAccountMapper;
    private final UserInfoMapper userInfoMapper;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        DefaultOAuth2User user = (DefaultOAuth2User) authentication.getPrincipal();
        String email = user.getAttribute("email").toString();
        UserAccount account = userAccountMapper.getUserByEmail(email);
        System.out.println(account);
        System.out.println("id : "+ account.getUser_email());
        UserInfo info = userInfoMapper.getUserInfoById(account.getUser_id());
        if(info == null){
            userInfoMapper.addUser_Info(new UserInfo(account.getUser_id(), user.getAttribute("sub").toString()));
        }
        loginService.setSession(email, request.getSession());
        response.sendRedirect("/main");
        System.out.println("user = " + user.getAttributes());
    }
}