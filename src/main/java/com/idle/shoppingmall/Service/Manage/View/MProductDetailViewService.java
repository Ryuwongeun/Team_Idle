package com.idle.shoppingmall.Service.Manage.View;

import com.idle.shoppingmall.ResponseDTO.Manage.MProductDetailView;
import com.idle.shoppingmall.mapper.Manage.MProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MProductDetailViewService {
    private final MProductMapper mapper;

    @Transactional(readOnly = true)
    public MProductDetailView getDetail(Long id) {
        return mapper.getDetail(id);
    }
}

