package com.idle.shoppingmall.Controller.ControllerView.ProductViews;

import com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO.PaymentListDTOtoSession;
import com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO.RequestPayDTO;
import com.idle.shoppingmall.Entity.Key.DetailKey;
import com.idle.shoppingmall.Entity.Product.ProductDetail;
import com.idle.shoppingmall.Entity.User.UserInfo;
import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import com.idle.shoppingmall.Service.Payment.PaymentService;
import com.idle.shoppingmall.Service.Product.ProductDetailService;
import com.idle.shoppingmall.Service.Product.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequiredArgsConstructor
public class PaymentViewListController {

    private final ProductService productService;
    private final PaymentService paymentService;
    private final ProductDetailService productDetailService;

    @PostMapping("/api/POST/paymentList")
    public ResponseEntity<CommonResponse> paymentList(@RequestBody List<String> list, HttpSession session) {
        List<PaymentListDTOtoSession> keys = IntStream.range(0, list.size())
                .mapToObj(i -> new PaymentListDTOtoSession(productService.findById(Long.parseLong(list.get(i).split(",")[0])), list.get(i).split(",")[1],
                        Integer.parseInt(list.get(i).split(",")[2])))
                .toList();
        if(!keys.isEmpty()) session.setAttribute("paymentList", keys);
        return keys.isEmpty() ? ResponseEntity.ok().body(new CommonResponse(400, "아무것도 안고르지 않았나요?")) :
                ResponseEntity.ok().body(new CommonResponse(200, "결제 준비 끝!"));
    }

    @PostMapping("/api/POST/checkPayment")
    public ResponseEntity<CommonResponse> checkPay(HttpSession session){
        System.out.println("!111111111111111111111111");
        UserInfo user = (UserInfo) session.getAttribute("user");
        if(user == null) return ResponseEntity.ok().body(new CommonResponse(666, "세션이 만료되었어요."));
        List<PaymentListDTOtoSession> paymentList = (List<PaymentListDTOtoSession>) session.getAttribute("paymentList");
        if(paymentList == null) return ResponseEntity.ok().body(new CommonResponse(400, "아무것도 안고르지 않았나요?"));
        //        상품 갯수 존재 여부 예외 처리
        return ResponseEntity.ok().body(paymentService.checkProduct(paymentList));
    }


    @PostMapping("/api/POST/payment")
    public ResponseEntity<CommonResponse> payment(@RequestBody RequestPayDTO request, HttpSession session) {
        System.out.println("result : "+request.getAddress() + " " + request.getPhone());
        UserInfo user = (UserInfo) session.getAttribute("user");
        List<PaymentListDTOtoSession> paymentList = (List<PaymentListDTOtoSession>) session.getAttribute("paymentList");

        CommonResponse response = paymentService.payAndDelivery(request, user.getUser_id(), paymentList); ;
        session.removeAttribute("paymentList");
        return ResponseEntity.ok().body(response);
    }
}
