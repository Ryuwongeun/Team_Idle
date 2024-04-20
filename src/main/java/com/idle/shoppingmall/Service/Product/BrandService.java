package com.idle.shoppingmall.Service.Product;

import com.idle.shoppingmall.Entity.Brand;
import com.idle.shoppingmall.ResponseDTO.Product.BrandListResponse;
import com.idle.shoppingmall.mapper.BrandMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandMapper mapper;

    @Transactional(readOnly = true)
    public List<BrandListResponse> findByName(String brand_name,int startPage, int endPage) {
        return mapper.findByName(brand_name, startPage, endPage);
    }

    public List<BrandListResponse> findAll(int startPage, int endPage) {
        return mapper.findAll(startPage, endPage);
    }
}
