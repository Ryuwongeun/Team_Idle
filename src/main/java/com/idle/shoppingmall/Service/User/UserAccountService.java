package com.idle.shoppingmall.Service.User;

import com.idle.shoppingmall.Entity.Product.ProductDetail;
import com.idle.shoppingmall.Entity.User.User_Account;
import com.idle.shoppingmall.mapper.User.UserAccountMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAccountService {

    private final UserAccountMapper userAccountMapper;

    @Transactional
    public Long addUserAccount(User_Account userAccountDTO) {
        return userAccountMapper.saveUserAccount(userAccountDTO);
    }

    @Transactional
    public User_Account getUserByEmail(String email) {
        return userAccountMapper.getUserByEmail(email);
    }

    @Transactional
    public List<User_Account> listAllUserAccounts() {
        return userAccountMapper.selectAllUserAccounts();
    }


    @Transactional
    public boolean updateUserAccount(User_Account userDTO) {
        boolean update = userAccountMapper.updateUserAccount(userDTO);

        return update;
    } // updateUserAccount

    @Transactional // 트랜잭션 처리 추가
    public boolean deleteUserAccount(String userEmail) {
        int deletedCount = userAccountMapper.deleteUserAccount(userEmail);
        return deletedCount > 0;

    }
}