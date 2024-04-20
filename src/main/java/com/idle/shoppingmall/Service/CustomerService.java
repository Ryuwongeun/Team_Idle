package com.idle.shoppingmall.Service;

import com.idle.shoppingmall.Config.Mail.RegisterMail;
import com.idle.shoppingmall.Entity.CS.CSAnswer;
import com.idle.shoppingmall.Entity.CS.CSEntity;
import com.idle.shoppingmall.RequestDTO.CustomerService.CSAnswerRequest;
import com.idle.shoppingmall.mapper.CustomerServiceMapper;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerServiceMapper mapper;

    @Transactional
    public Integer answerCS(CSAnswerRequest request, Long created_who) {
        mapper.answerCS(CSAnswer.builder()
                .cs_id(request.getCs_id())
                .content(request.getContent())
                .created_who(created_who)
                .created_at(LocalDateTime.now())
                .build());
        return mapper.updateCS(request.getState(), request.getCs_id());
    }

    @Transactional
    public Integer addCustomerService(Long payment_id, String content, Long created_who) {
        return mapper.addCustomerService(CSEntity.builder()
                .payment_id(payment_id)
                .content(content)
                .created_who(created_who)
                .state("WAIT")
                .created_at(LocalDateTime.now())
                .build());
    }

    @Transactional(readOnly = true)
    public String sendMail(Long cs_id){
        return mapper.getEmail(cs_id);
    }
}
