package com.idle.shoppingmall.Controller.ControllerView;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserAccountViewController {

    @PostMapping("/main")
    String signupOk() {

        return "main";
    } // signupOk

    @PostMapping("/FE/login")
    String loginOk() {

        return "/FE/login";
    } // loginOk

} // end class
