package com.idle.shoppingmall.mapper;


import com.idle.shoppingmall.Entity.Key.LoveKey;
import com.idle.shoppingmall.Entity.Love;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LoveMapper {

    Long addLove(@Param("love")Love loveDTO);

    Love findLove(@Param("find")LoveKey loveKey); // 특정 조회
    List<Love> loveList(@Param("list")Love loveDTO); // 전체 조회

    void deleteLove(@Param("remove")Love loveDTO);

} // end interface
