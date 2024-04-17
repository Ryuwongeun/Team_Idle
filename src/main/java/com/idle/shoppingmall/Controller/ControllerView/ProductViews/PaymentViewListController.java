package com.idle.shoppingmall.Controller.ControllerView.ProductViews;

import com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO.PaymentListDTOtoSession;
import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequiredArgsConstructor
public class PaymentViewListController {


    @PostMapping("/api/POST/paymentList")
    public ResponseEntity<CommonResponse> paymentList(@RequestBody List<String> list, HttpSession session) {
        List<PaymentListDTOtoSession> keys = IntStream.range(0, list.size())
                .mapToObj(i -> new PaymentListDTOtoSession(Long.parseLong(list.get(i).split(",")[0]), list.get(i).split(",")[1]))
                .toList();
        if(!keys.isEmpty()) session.setAttribute("paymentList", keys);
        return keys.isEmpty() ? ResponseEntity.ok().body(new CommonResponse(400, "아무것도 안고르지 않았나요?")) :
                ResponseEntity.ok().body(new CommonResponse(200, "결제 준비 끝!"));
    }
}
