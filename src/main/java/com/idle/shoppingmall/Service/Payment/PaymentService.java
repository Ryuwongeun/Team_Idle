package com.idle.shoppingmall.Service.Payment;

import com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO.PaymentListDTOtoSession;
import com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO.RequestPayDTO;
import com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO.SalesDTO;
import com.idle.shoppingmall.Entity.Delivery;
import com.idle.shoppingmall.Entity.Key.DetailKey;
import com.idle.shoppingmall.Entity.Payment;
import com.idle.shoppingmall.Entity.Product.ProductDetail;
import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import com.idle.shoppingmall.mapper.Payment.PaymentMapper;
import com.idle.shoppingmall.mapper.Product.ProductDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentMapper paymentMapper;
    private final ProductDetailMapper productMapper;

    public Long addPayment(Payment paymentDTO) {
        return paymentMapper.savePayment(paymentDTO);
    }

    public Payment findById(Long paymentId) {
        return paymentMapper.findById(paymentId);
    }

    public Integer delete(Long paymentId) {
        return paymentMapper.delete(paymentId);
    }

    @Transactional(readOnly = true)
    public CommonResponse checkProduct(List<PaymentListDTOtoSession> paymentList){
        List<String> isStockInsufficient = paymentList.stream()
                .map(payment -> {
                    ProductDetail productDetail = productMapper.findBySize(new DetailKey(
                            payment.getProduct().getProduct_id(),
                            payment.getSize()));
                    if (productDetail == null) return "없는 상품";
                    return  productDetail.getPd_before_count() < payment.getCount() ?
                            payment.getProduct().getPd_name() : null ;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        if (isStockInsufficient.size() > 0) {
            String result = isStockInsufficient.stream()
                    .collect(Collectors.joining(", "));
            System.out.println("재고 부족");
            return new CommonResponse(500,"상품 : "+result+"의 재고가 부족합니다.");
        }
        System.out.println("가느으으응ㄴ으능ㄴ");
        return new CommonResponse(200, "결제 가능");
    }

    @Transactional
    public CommonResponse payAndDelivery(RequestPayDTO dto, Long who, List<PaymentListDTOtoSession> paymentList) {
//        상품 존재 유무 예외 처리
        List<String> details = paymentList.stream()
                .map(payment ->{ Integer result = productMapper.sales(new SalesDTO(
                        payment.getProduct().getProduct_id(),
                        payment.getSize(),
                        payment.getCount()));
                    return result != 0 ? payment.getProduct().getPd_name() : null ;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        if (details.size() > 0) {
            String result = details.stream()
                    .collect(Collectors.joining(", "));
            return new CommonResponse(500,"상품 : "+result+ "는 존재하지 않는 상품입니다.");
        }

        Delivery delivery = Delivery.builder()
                .tg_pnum(dto.getPhone())
                .address(dto.getAddress())
                .state("WAIT")
                .created_at(LocalDateTime.now())
                .build();
        paymentMapper.setDelivery(delivery);
        System.out.println("delivery : " + delivery.getDelivery_id());


        List<Payment> payments = IntStream.range(0, paymentList.size())
                .mapToObj(i -> Payment.builder()
                        .created_who(who)
                        .product_id(paymentList.get(i).getProduct().getProduct_id())
                        .total_price(paymentList.get(i).getProduct().getPd_price()*paymentList.get(i).getCount())
                        .size(paymentList.get(i).getSize())
                        .count(paymentList.get(i).getCount())
                        .created_at(LocalDateTime.now())
                        .delivery_id(delivery.getDelivery_id())
                        .build())
                .toList();
        paymentMapper.setPayment(payments);

        return new CommonResponse(200,"주문이 완료되었습니다.");

    }
}
