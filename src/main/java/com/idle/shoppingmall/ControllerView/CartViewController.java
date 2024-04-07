package com.idle.shoppingmall.ControllerView;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class CartViewController {

    @GetMapping("FE/cart")
    String cartList() {



        return "FE/cart";
    } // cartList

} // end class
