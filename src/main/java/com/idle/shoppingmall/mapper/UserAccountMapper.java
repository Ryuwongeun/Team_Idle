package com.idle.shoppingmall.mapper;

import com.idle.shoppingmall.Entity.User_Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserAccountMapper {


    Long saveUserAccount(@Param("userAccount") User_Account userAccountDTO);
}
