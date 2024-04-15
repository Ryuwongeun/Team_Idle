package com.idle.shoppingmall.Controller.ControllerView;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class OrderViewController {

    @GetMapping("/order")
    String order() {


        return "FE/order";
    }  // order

} // end class
