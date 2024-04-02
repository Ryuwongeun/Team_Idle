package com.idle.shoppingmall.Service.User;

import com.idle.shoppingmall.Entity.User.User_Account;
import com.idle.shoppingmall.mapper.User.UserAccountMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountService {

    private final UserAccountMapper userAccountMapper;

    @Transactional
    public Long addUserAccount(User_Account userAccountDTO){
        return userAccountMapper.saveUserAccount(userAccountDTO);
    }

    @Transactional
    public User_Account getUserByEmail(String email){
        return userAccountMapper.getUserByEmail(email);
    }
}
