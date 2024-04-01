package com.idle.shoppingmall.Service;

import com.idle.shoppingmall.Entity.User_Account;
import com.idle.shoppingmall.mapper.UserAccountMapper;
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
}
