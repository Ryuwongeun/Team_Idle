package com.idle.shoppingmall.Service.User;

import com.idle.shoppingmall.Entity.User.UserAccount;
import com.idle.shoppingmall.mapper.User.UserAccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OAuth2UserService extends DefaultOAuth2UserService {

    private final UserAccountMapper userAccountMapper;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        String email = (String) super.loadUser(userRequest).getAttributes().get("email");
        String name = (String) super.loadUser(userRequest).getAttributes().get("sub");

        OAuth2User oAuth2User = super.loadUser(userRequest);
        isExist(email, name);

        return super.loadUser(userRequest);
    }
    @Transactional
    public void isExist(String email, String name) {
        UserAccount user = userAccountMapper.getUserByEmail(email);
        if(user == null){
            userAccountMapper.saveUserAccount(UserAccount.builder()
                    .user_email(email)
                    .user_password(new BCryptPasswordEncoder().encode(name))
                    .user_role(UserAccount.UserRole.USER)
                    .user_pnum("010-0000-0000")
                    .build());
        }
    }
}