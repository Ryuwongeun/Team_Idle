package com.idle.shoppingmall.Controller.ControllerAPI;


import com.idle.shoppingmall.Entity.Key.LoveKey;
import com.idle.shoppingmall.Entity.Love;
import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.Entity.User.UserInfo;
import com.idle.shoppingmall.RequestDTO.Love.LoveAddRequest;
import com.idle.shoppingmall.RequestDTO.Love.LoveDeleteRequest;
import com.idle.shoppingmall.ResponseDTO.Love.LoveAddResponse;
import com.idle.shoppingmall.ResponseDTO.Love.LoveDeleteResponse;
import com.idle.shoppingmall.Service.LoveService;
import com.idle.shoppingmall.Service.Product.ProductService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class LoveController {

    private final LoveService loveService;
    private final ProductService productService;

    @PostMapping("api/POST/addLove")
    public ResponseEntity<?> AddLove(@RequestBody @Valid LoveAddRequest request,
                                     HttpSession session) {
        UserInfo user = (UserInfo) session.getAttribute("user");

        if (user == null) {
            return ResponseEntity.ok().body("로그인이 필요합니다.");
        }

        Product product = productService.findById(request.getProduct_id());
        if (product == null) {
            return ResponseEntity.ok().body("존재하지 않는 상품입니다.");
        }

        if (request.isLove()) {
            // 좋아요 추가 로직
            Long id = loveService.addLove(Love.builder()
                    .product_id(request.getProduct_id())
                    .created_who(user.getUser_id())
                    .created_at(LocalDateTime.now())
                    .build());

            if (id == null) {
                return ResponseEntity.ok().body("찜하기에 실패했습니다.");
            }

            return ResponseEntity.ok().body("찜하기에 성공했습니다.");
        } else {
            // 좋아요 취소 로직
            LoveKey loveKey = new LoveKey(request.getProduct_id(), user.getUser_id());
            Love love = loveService.findLove(loveKey);

            if (love == null) {
                return ResponseEntity.ok().body("찾는 상품이 존재하지 않습니다.");
            }

            loveService.delLove(love);
            return ResponseEntity.ok().body("찜하기 취소했습니다.");
        }
    }
}
