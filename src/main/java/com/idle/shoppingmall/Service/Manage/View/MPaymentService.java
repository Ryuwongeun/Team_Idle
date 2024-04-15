package com.idle.shoppingmall.Service.Manage.View;

import com.idle.shoppingmall.ResponseDTO.Manage.PaymentListResponse;
import com.idle.shoppingmall.mapper.Manage.DTO.MPaymentSortAndOrder;
import com.idle.shoppingmall.mapper.Manage.MPaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MPaymentService {
    private final MPaymentMapper mapper;

    public List<PaymentListResponse> getPaymentList(MPaymentSortAndOrder data){
        return mapper.getPaymentList(data);
    }
}
