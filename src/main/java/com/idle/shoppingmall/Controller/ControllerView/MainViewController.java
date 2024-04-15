package com.idle.shoppingmall.Controller.ControllerView;


import jakarta.servlet.http.HttpSession;
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

    @GetMapping("/login")
    String login() {

        return "login";
    } // login

    @GetMapping("/join")
    String join(HttpSession session) {
        System.out.println("user : "+session.getAttribute("user"));
        return "FE/join";
    } // join


} // end class
