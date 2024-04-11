package com.idle.shoppingmall.ControllerAPI.Manage;

import com.idle.shoppingmall.ControllerAPI.Manage.Storage.UploadImages;
import com.idle.shoppingmall.Entity.User.UserInfo;
import com.idle.shoppingmall.RequestDTO.Product.Add.ProductAddRequest;
import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import com.idle.shoppingmall.Service.Product.ProductAddService;
import com.idle.shoppingmall.Service.Storage.NCPObjectStorageService;
import com.idle.shoppingmall.Service.Storage.UploadProductImgService;
import com.idle.shoppingmall.Service.User.UserInfoService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductAddController {
    private final UserInfoService userInfoService;
    private final ProductAddService productAddService;
    private final UploadImages uploadImages;

    @PostMapping("/api/POST/manage/productAdd")
    public ResponseEntity<CommonResponse> productAdd(@ModelAttribute ProductAddRequest request,
                                                     HttpSession session){
        System.out.println(request.getPd_name());
        System.out.println(request.getSizes().get(1).getSize());
        UserInfo user = (UserInfo) session.getAttribute("user");
        user = userInfoService.getUserInfoById(11L);
        if(user==null){
            return ResponseEntity.ok().body(new CommonResponse(666,"로그인이 필요합니다."));
        }
        Long id = productAddService.addProduct(request, user.getUser_id());
        uploadImages.productUploadImages(request.getImages(), id);

        return id == null ? ResponseEntity.ok().body(new CommonResponse(600, "상품 등록 실패")) :
                ResponseEntity.ok().body(new CommonResponse(200, "상품 등록 성공"));
    }
}
