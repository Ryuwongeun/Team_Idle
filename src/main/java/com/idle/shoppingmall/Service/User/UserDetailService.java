package com.idle.shoppingmall.Service.User;

import com.idle.shoppingmall.Entity.User.User_Account;
import com.idle.shoppingmall.mapper.User.UserAccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserAccountMapper userAccountMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User_Account user = userAccountMapper.getUserByEmail(username);
        //User = Security에서 제공해주는 객체
        return User.builder()
                .username(user.getUser_email())
                .password(user.getUser_password())
                .roles(user.getUser_role().toString())
                .build();
    }
}
