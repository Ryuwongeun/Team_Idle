package com.idle.shoppingmall.Service.User;

import com.idle.shoppingmall.Entity.User.UserLog;
import com.idle.shoppingmall.mapper.User.UserLogMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLogService {
    private final UserLogMapper userLogMapper;

    public void insertUserLog(UserLog log){
        userLogMapper.insertUserLog(log);
    }
}
