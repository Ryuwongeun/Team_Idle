package com.idle.shoppingmall.Service.User;

import com.idle.shoppingmall.Entity.User.UserAccount;
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
    public Long addUserAccount(UserAccount userAccountDTO) {
        return userAccountMapper.saveUserAccount(userAccountDTO);
    }

    @Transactional
    public UserAccount getUserByEmail(String email) {
        return userAccountMapper.getUserByEmail(email);
    }

    @Transactional
    public List<UserAccount> listAllUserAccounts() {
        return userAccountMapper.selectAllUserAccounts();
    }


    @Transactional
    public boolean updateUserAccount(UserAccount userDTO) {
        boolean update = userAccountMapper.updateUserAccount(userDTO);

        return update;
    } // updateUserAccount

    @Transactional // 트랜잭션 처리 추가
    public boolean deleteUserAccount(String userEmail) {
        int deletedCount = userAccountMapper.deleteUserAccount(userEmail);
        return deletedCount > 0;

    }
}