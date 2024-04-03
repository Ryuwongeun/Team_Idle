package com.idle.shoppingmall.Service;

import com.idle.shoppingmall.Entity.Payment;
import com.idle.shoppingmall.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentMapper paymentMapper;

    public Long addPayment(Payment paymentDTO) {
        return paymentMapper.savePayment(paymentDTO);
    }
}
