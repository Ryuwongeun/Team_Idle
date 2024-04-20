package com.idle.shoppingmall.Service.Payment;

import com.idle.shoppingmall.ResponseDTO.Order.OrderListViewResponse;
import com.idle.shoppingmall.mapper.Payment.PayLogManageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PayLogManageService {
    private final PayLogManageMapper payLogManageMapper;

    //유저가 자신의 주문내역을 조회
    @Transactional(readOnly = true)
    public List<OrderListViewResponse> UserOrderListView(Long created_who, int size, int offset){
        return payLogManageMapper.UserFindOrderList(created_who, size, offset);
    }
}
