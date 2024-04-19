package com.idle.shoppingmall.Service;

import com.idle.shoppingmall.Entity.CSEntity;
import com.idle.shoppingmall.mapper.CustomerServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerServiceMapper mapper;

    public Integer addCustomerService(Long payment_id, String content, Long created_who) {
        return mapper.addCustomerService(CSEntity.builder()
                .payment_id(payment_id)
                .content(content)
                .created_who(created_who)
                .state("WAIT")
                .created_at(LocalDateTime.now())
                .build());
    }
}
