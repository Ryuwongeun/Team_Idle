package com.idle.shoppingmall.Service.Manage.View;

import com.idle.shoppingmall.ResponseDTO.Manage.MCSListRepsonse;
import com.idle.shoppingmall.mapper.CustomerServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MCSService {
    private final CustomerServiceMapper mapper;

    public List<MCSListRepsonse> getCSList(String name, int page, int offset){
        return mapper.getCSList(name, page, offset);
    }
}
