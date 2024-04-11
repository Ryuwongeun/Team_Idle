package com.idle.shoppingmall.Service.Manage.View;

import com.idle.shoppingmall.ResponseDTO.Manage.MBrandListResponse;
import com.idle.shoppingmall.mapper.Manage.MBrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MBrandService {
    private final MBrandMapper mapper;

    public List<MBrandListResponse> getBrandDetails(){
        return mapper.getBrandDetails();
    }
}
