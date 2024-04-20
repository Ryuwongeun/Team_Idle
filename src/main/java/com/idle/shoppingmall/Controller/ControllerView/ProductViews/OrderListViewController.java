package com.idle.shoppingmall.Controller.ControllerView.ProductViews;

import com.idle.shoppingmall.Entity.User.UserInfo;
import com.idle.shoppingmall.ResponseDTO.Order.OrderListViewResponse;
import com.idle.shoppingmall.Service.Payment.PayLogManageService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderListViewController {

    private final int PAGESIZE = 10;
    private final PayLogManageService paymentService;

    //유저가 자신의 주문내역을 조회
    @PostMapping("/api/view/orderList")
    public ResponseEntity<List<OrderListViewResponse>> getOrderList(@RequestParam(defaultValue = "1") int page, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        if(user == null) return null;
        int startPage = (page - 1) * PAGESIZE;
        int endPage = PAGESIZE;
        List<OrderListViewResponse> responses = paymentService.UserOrderListView(user.getUser_id(), startPage, endPage);
        log.info("응답 리스트 사이즈 : ", responses.size());
        return ResponseEntity.ok().body(responses);
    }
}
