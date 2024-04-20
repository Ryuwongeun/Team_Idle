package com.idle.shoppingmall.Controller.ControllerAPI;

import com.idle.shoppingmall.Entity.User.UserInfo;
import com.idle.shoppingmall.RequestDTO.CustomerService.CustomerServiceAddRequest;
import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import com.idle.shoppingmall.Service.CustomerService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerServiceApiController {
    private final CustomerService customerService;

    @PostMapping("/api/POST/customerService")
    public ResponseEntity<CommonResponse> addCustomerService(@RequestBody CustomerServiceAddRequest request, HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        if(user == null) return ResponseEntity.ok().body(new CommonResponse(666, "세션이 만료되었습니다. 다시 로그인 해주세요."));

        return customerService.addCustomerService(request.getPayment_id(), request.getContent(), user.getUser_id())==null ?
                ResponseEntity.ok().body(new CommonResponse(500, "고객센터 문의 등록에 실패했습니다.")) :
                ResponseEntity.ok().body(new CommonResponse(200, "고객센터 문의 등록에 성공했습니다."));
    }
}
