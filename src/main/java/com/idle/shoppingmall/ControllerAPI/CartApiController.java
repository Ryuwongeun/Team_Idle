package com.idle.shoppingmall.ControllerAPI;


import com.idle.shoppingmall.Entity.Cart;
import com.idle.shoppingmall.Entity.Key.CartKey;
import com.idle.shoppingmall.Entity.Product.ProductDetail;
import com.idle.shoppingmall.Entity.User.User_Info;
import com.idle.shoppingmall.RequestDTO.CartAddRequest;
import com.idle.shoppingmall.ResponseDTO.Test.CartAddResponse;
import com.idle.shoppingmall.Service.CartService;
import com.idle.shoppingmall.Service.Product.ProductDetailService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CartApiController {

    private final CartService cartService;
    private final ProductDetailService productDetailService;

    @PostMapping("api/POST/addCart")
    public ResponseEntity<CartAddResponse> addCart(@RequestBody CartAddRequest request,
                                                   HttpSession session){
        User_Info user = (User_Info) session.getAttribute("user");
        if(user==null){
            return ResponseEntity.ok().body(new CartAddResponse(700, "로그인이 필요합니다.", null));
        }
        ProductDetail productDetail =  productDetailService.findDetail(request.getProduct_id(), request.getSize());
        if(productDetail == null){
            return ResponseEntity.ok().body(new CartAddResponse(400, "상품이 없습니다.", request.getProduct_id()));
        }
        CartKey key = new CartKey(1L, request.getProduct_id(), request.getSize());
        Cart cart = cartService.findCart(key);
        if(cart == null){
            cartService.addCart(Cart.builder()
                    .created_who(user.getUser_id())
                    .product_id(request.getProduct_id())
                    .size(request.getSize())
                    .count(request.getCount())
                    .build());
            return ResponseEntity.ok().body(new CartAddResponse(200, "장바구니 등록에 성공했습니다.", request.getProduct_id()));
        }
        cart.updateCount(request.getCount());
        cartService.updateCart(cart);
        return ResponseEntity.ok().body(new CartAddResponse(200, "수량이 더해졌습니다.", request.getProduct_id()));
    }

//    @PostMapping("api/POST/addCart")
//    public ResponseEntity<CartAddResponse> addCart(@RequestBody CartAddRequest request) {
//        if(request.getProduct_id() == null) {
//            return ResponseEntity.ok().body(new CartAddResponse(404, "상품이 없습니다.", request.getProduct_id()));
//        } // if
//
//
//        List<Cart> list = cartService.selectCart(Cart.builder()
//                .created_who(request.getCreated_who())
//                .build());
//
//        if(list.isEmpty()) {
//
//            cartService.addCart(
//                    Cart.builder()
//                            .created_who(request.getCreated_who())
//                            .product_id(request.getProduct_id())
//                            .size(request.getSize())
//                            .count(request.getCount())
//                            .build()
//            );
//            return ResponseEntity.ok().body(new CartAddResponse(100, "장바구니 등록에 성공했습니다.", request.getProduct_id()));
//
//
//        } // if
//
//
//
//        for (Cart cartDTO : list) {
//
//            if (cartDTO.getCreated_who().equals(request.getCreated_who()) &&
//                    cartDTO.getProduct_id().equals(request.getProduct_id()) &&
//                    cartDTO.getSize().equals(request.getSize())
//            ) {
//                cartService.updateCart(Cart.builder()
//                        .created_who(request.getCreated_who())
//                        .product_id(request.getProduct_id())
//                        .size(request.getSize())
//                        .count(request.getCount())
//                        .build());
//
//                return ResponseEntity.ok().body(new CartAddResponse(100, "기존 상품에 추가됐습니다.", request.getProduct_id()));
//
//
//            } // if
//
//        } // enhanced for
//
//        cartService.addCart(
//                Cart.builder()
//                        .created_who(request.getCreated_who())
//                        .product_id(request.getProduct_id())
//                        .size(request.getSize())
//                        .count(request.getCount())
//                        .build()
//        );
//
//        return ResponseEntity.ok().body(new CartAddResponse(100, "장바구니 등록에 성공했습니다.", request.getProduct_id()));
//
//
//    } // addCart

} // end class
