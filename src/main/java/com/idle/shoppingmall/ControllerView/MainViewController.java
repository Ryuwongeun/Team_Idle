package com.idle.shoppingmall.ControllerView;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class MainViewController {


    @GetMapping("/main")
    String main() {

        return "main";
    } // main

    @GetMapping("/FE/login")
    String login() {

        return "/FE/login";
    } // login

    @GetMapping("/FE/join")
    String join() {

        return "/FE/join";
    } // join



} // end class
