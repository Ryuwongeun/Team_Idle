package com.idle.shoppingmall.mapper.User;

import com.idle.shoppingmall.Entity.User.User_Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserAccountMapper {
    Long saveUserAccount(@Param("userAccount") User_Account userAccountDTO);
    User_Account getUserByEmail(@Param("email") String email);

    void updateLastLogin(@Param("user_id") Long user_id);
}
