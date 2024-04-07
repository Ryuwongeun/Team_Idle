package com.idle.shoppingmall.ControllerView;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class OrderViewController {

    @GetMapping("/FE/order")
    String order() {


        return "/FE/order";
    }  // order

} // end class
