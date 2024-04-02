package com.idle.shoppingmall.ControllerAPI;


import com.idle.shoppingmall.Entity.Cart;
import com.idle.shoppingmall.RequestDTO.CartAddRequest;
import com.idle.shoppingmall.ResponseDTO.Test.CartAddResponse;
import com.idle.shoppingmall.Service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartApiController {

    private final CartService cartService;

    @PostMapping("api/POST/addCart")
    public ResponseEntity<CartAddResponse> addCart(@RequestBody CartAddRequest request) {
        if(request.getProduct_id() == null) {
            return ResponseEntity.ok().body(new CartAddResponse(404, "상품이 없습니다.", request.getProduct_id()));
        } // if


        List<Cart> list = cartService.selectCart(Cart.builder()
                .created_who(request.getCreated_who())
                .build());

        if(list.isEmpty()) {

            cartService.addCart(
                    Cart.builder()
                            .created_who(request.getCreated_who())
                            .product_id(request.getProduct_id())
                            .size(request.getSize())
                            .count(request.getCount())
                            .build()
            );
            return ResponseEntity.ok().body(new CartAddResponse(100, "장바구니 등록에 성공했습니다.", request.getProduct_id()));


        } // if



        for (Cart cartDTO : list) {

            if (cartDTO.getCreated_who().equals(request.getCreated_who()) &&
                    cartDTO.getProduct_id().equals(request.getProduct_id()) &&
                    cartDTO.getSize().equals(request.getSize())
            ) {
                cartService.updateCart(Cart.builder()
                        .created_who(request.getCreated_who())
                        .product_id(request.getProduct_id())
                        .size(request.getSize())
                        .count(request.getCount())
                        .build());

                return ResponseEntity.ok().body(new CartAddResponse(100, "기존 상품에 추가됐습니다.", request.getProduct_id()));


            } // if

        } // enhanced for

        cartService.addCart(
                Cart.builder()
                        .created_who(request.getCreated_who())
                        .product_id(request.getProduct_id())
                        .size(request.getSize())
                        .count(request.getCount())
                        .build()
        );

        return ResponseEntity.ok().body(new CartAddResponse(100, "장바구니 등록에 성공했습니다.", request.getProduct_id()));


    } // addCart

} // end class
