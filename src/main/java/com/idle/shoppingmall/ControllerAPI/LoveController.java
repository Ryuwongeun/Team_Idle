package com.idle.shoppingmall.ControllerAPI;


import com.idle.shoppingmall.Entity.Key.LoveKey;
import com.idle.shoppingmall.Entity.Love;
import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.Entity.User.User_Info;
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
    public ResponseEntity<LoveAddResponse> addLove(@RequestBody @Valid LoveAddRequest request,
                                                   HttpSession session) {

        User_Info user = (User_Info) session.getAttribute("user");

        if(user==null){
            return ResponseEntity.ok().body(new LoveAddResponse(700, "로그인이 필요합니다.", null));
        } // if

        Product product = productService.findById(request.getProduct_id());

        if(product == null) {
            return ResponseEntity.ok().body(new LoveAddResponse(400, "존재하지 않는 상품입니다.", null));
        } // if

        Long id = loveService.addLove(Love.builder()
                        .product_id(request.getProduct_id())
                        .created_who(user.getUser_id())
                        .created_at(LocalDateTime.now())
                        .build());

        if(id == null) {
            return ResponseEntity.ok().body(new LoveAddResponse(400, "찜하기에 실패했습니다.", null));
        } // if

        return ResponseEntity.ok().body(new LoveAddResponse(200, "찜하기에 성공했습니다.", request.getProduct_id()));

    } // addLove


    @PostMapping("api/DELETE/Love")
    public ResponseEntity<LoveDeleteResponse> delLove(@RequestBody @Valid LoveDeleteRequest request
            , HttpSession session) {

        User_Info user = (User_Info) session.getAttribute("user");

        if(user==null){
            return ResponseEntity.ok().body(new LoveDeleteResponse(700, "로그인이 필요합니다.", null));
        } // if

        LoveKey loveKey = new LoveKey(request.getProduct_id(),user.getUser_id());
        Love love = loveService.findLove(loveKey);

        if(love == null) {
            return ResponseEntity.ok().body(new LoveDeleteResponse(700, "찾는 상품이 존재하지 않습니다.", null));
        } // if

        loveService.delLove(love);

        return ResponseEntity.ok().body(new LoveDeleteResponse(200, "찜하기 취소했습니다.", request.getProduct_id()));

    } // delLove



} // end class
