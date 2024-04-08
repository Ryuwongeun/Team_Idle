package com.idle.shoppingmall.Service.Manage.View;

import com.idle.shoppingmall.ResponseDTO.Manage.MProductListView;
import com.idle.shoppingmall.mapper.Manage.DTO.MProductSortAndOrder;
import com.idle.shoppingmall.mapper.Manage.MProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MProductService {
    private final MProductMapper mapper;

    @Transactional(readOnly = true)
    public List<MProductListView> sortAndSearch(MProductSortAndOrder data) {
        System.out.println("result : "+mapper.sortAndSearch(data));
        return mapper.sortAndSearch(data);
    }

    @Transactional(readOnly = true)
    public List<MProductListView> getList(int page, int pageSize) {
        return mapper.getList(page, pageSize);
    }
}
