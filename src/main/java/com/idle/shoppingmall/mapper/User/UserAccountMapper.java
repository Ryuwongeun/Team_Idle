package com.idle.shoppingmall.mapper.User;

import com.idle.shoppingmall.Entity.User.UserAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface  UserAccountMapper {
    Long saveUserAccount(@Param("userAccount") UserAccount userAccountDTO);
    UserAccount getUserByEmail(@Param("email") String email);

    void updateLastLogin(@Param("user_id") Long user_id);

    List<UserAccount> selectAllUserAccounts(); // 메서드 추가

    boolean updateUserAccount(@Param("updateUser") UserAccount userDTO);


    int deleteUserAccount(@Param("user_email") String email);
}
