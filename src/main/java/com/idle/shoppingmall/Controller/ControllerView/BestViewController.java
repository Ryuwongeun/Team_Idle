package com.idle.shoppingmall.Controller.ControllerView;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class BestViewController {

    @GetMapping("/FE/best")
    String bestList() {

        return "/FE/best";
    } // bestList

} // end class
