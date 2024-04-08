package com.idle.shoppingmall.ControllerAPI.Manage;

import com.idle.shoppingmall.Entity.User.UserInfo;
import com.idle.shoppingmall.RequestDTO.Product.Add.ProductAddRequest;
import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import com.idle.shoppingmall.Service.Product.ProductAddService;
import com.idle.shoppingmall.Service.User.UserInfoService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductAddController {
    private final UserInfoService userInfoService;
    private final ProductAddService productAddService;

    @PostMapping("/api/POST/manage/productAdd")
    public ResponseEntity<CommonResponse> productAdd(@RequestBody @Valid ProductAddRequest request,
                                                     HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        user = userInfoService.getUserInfoById(11L);
        System.out.println("request = " + request);
        System.out.println("request.getPd_name() = " + request.getPd_name());
        System.out.println("request.getBrand() = " + request.getBrand());
        System.out.println("request.getPd_price() = " + request.getPd_price());
        System.out.println("request.getPd_category() = " + request.getPd_category());
        System.out.println("request.getSizes() = " + request.getSizes().get(1).getSize());
        productAddService.addProduct(request, user.getUser_id());
        return null;
    }
}
