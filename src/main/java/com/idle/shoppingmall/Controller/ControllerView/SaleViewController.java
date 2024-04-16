package com.idle.shoppingmall.Controller.ControllerView;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class SaleViewController {

    @GetMapping("/sale")
    String sale() {

        return "/FE/sale";
    } // sale

} // end class
