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
        Integer id = productAddService.addProduct(request, user.getUser_id());
        return id == null ? ResponseEntity.ok().body(new CommonResponse(600, "상품 등록 실패")) :
                ResponseEntity.ok().body(new CommonResponse(200, "상품 등록 성공"));
    }
}
