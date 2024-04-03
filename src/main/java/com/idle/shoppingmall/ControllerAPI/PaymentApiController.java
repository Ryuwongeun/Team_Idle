package com.idle.shoppingmall.ControllerAPI;

import com.idle.shoppingmall.Entity.Payment;
import com.idle.shoppingmall.Entity.Product.ProductDetail;
import com.idle.shoppingmall.RequestDTO.PaymentAddRequest;
import com.idle.shoppingmall.ResponseDTO.Payment.PaymentAddResponse;
import com.idle.shoppingmall.Service.PaymentService;
import com.idle.shoppingmall.Service.Product.ProductDetailService;
import com.idle.shoppingmall.Service.Product.ProductLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentApiController {
    private final PaymentService paymentService;
    private final ProductLogService productLogService;
    private final ProductDetailService productDetailService;

    @PostMapping("api/POST/addPayment")
    public ResponseEntity<PaymentAddResponse> addPayment(@RequestBody PaymentAddRequest request) {
        ProductDetail productDetail = productDetailService.findDetail(request.getProduct_id(), request.getSize());
        if(productDetail == null)
            return ResponseEntity.ok().body(new PaymentAddResponse(500, "물품이 없습니다.", null));

        Long id = paymentService.addPayment(
                Payment.builder()
                        .payment_id(request.getPayment_id())
                        .created_who(request.getCreated_who())
                        .product_id(request.getProduct_id())
                        .total_price(request.getTotal_price())
                        .size(request.getSize())
                        .count(request.getCount())
                        .build()
        );
        if(id == null)
            return ResponseEntity.ok().body(new PaymentAddResponse(600, "결제 실패", null));
        return ResponseEntity.ok().body(new PaymentAddResponse(200, "성공", request.getCreated_who(), request.getProduct_id(), request.getTotal_price(), request.getSize()));
    }

}
