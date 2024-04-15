package com.idle.shoppingmall.Controller.ControllerView.Manage;


import com.idle.shoppingmall.ResponseDTO.Manage.PaymentListResponse;
import com.idle.shoppingmall.Service.Manage.View.MPaymentService;
import com.idle.shoppingmall.mapper.Manage.DTO.MPaymentSortAndOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaymentViewController {
    private final MPaymentService paymentService;
    private final int PAGINGSIZE = 10;

    @PostMapping("/GET/manage/order/search")
    public ResponseEntity<List<PaymentListResponse>> getPaymentList(@RequestParam(required = false, defaultValue = "") String name,
                                                                    @RequestParam int page){
        int paging = page * PAGINGSIZE;
        return ResponseEntity.ok().body(paymentService.getPaymentList(new MPaymentSortAndOrder(name, paging, paging+PAGINGSIZE)));
    }
}
