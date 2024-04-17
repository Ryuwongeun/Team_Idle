package com.idle.shoppingmall.Service.Payment;

import com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO.PaymentListDTOtoSession;
import com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO.RequestPayDTO;
import com.idle.shoppingmall.Entity.Delivery;
import com.idle.shoppingmall.Entity.Payment;
import com.idle.shoppingmall.mapper.Payment.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentMapper paymentMapper;

    public Long addPayment(Payment paymentDTO) {
        return paymentMapper.savePayment(paymentDTO);
    }

    public Payment findById(Long paymentId) {
        return paymentMapper.findById(paymentId);
    }

    public Integer delete(Long paymentId) {
        return paymentMapper.delete(paymentId);
    }

    public Integer payAndDelivery(RequestPayDTO dto, Long who, List<PaymentListDTOtoSession> paymentList) {
        List<Payment> payments = IntStream.range(0, paymentList.size())
                .mapToObj(i -> Payment.builder()
                        .created_who(who)
                        .product_id(paymentList.get(i).getProduct().getProduct_id())
                        .total_price(paymentList.get(i).getProduct().getPd_price()*paymentList.get(i).getCount())
                        .size(paymentList.get(i).getSize())
                        .count(paymentList.get(i).getCount())
                        .created_at(LocalDateTime.now())
                        .build())
                .toList();
        Delivery delivery = Delivery.builder()
                .tg_pnum(dto.getPhone())
                .address(dto.getAddress())
                .state("WAIT")
                .created_at(LocalDateTime.now())
                .build();

        paymentMapper.setDelivery(delivery);
        return paymentMapper.setPayment(payments);

    }
}
