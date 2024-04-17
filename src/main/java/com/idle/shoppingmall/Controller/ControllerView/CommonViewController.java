package com.idle.shoppingmall.Controller.ControllerView;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommonViewController {

    @GetMapping("/best")
    String bestList() {
        return "/best/best";
    } // bestList

    @GetMapping("/like")
    String likeList() {
        return "/best/like";
    } // likeList

    @GetMapping("/comment")
    String commentList() {
        return "/best/comment";
    } // commentList
    @GetMapping("/cart")
    String cartList() {
        return "/FE/cart";
    } // cartList

    @GetMapping("/event")
    String event() {
        return "/FE/event";
    } // event

    @GetMapping("/main")
    String main() {
        return "/main";
    } // main

    @GetMapping("/login")
    String login() {
        return "/login";
    } // login

    @GetMapping("/join")
    String join(HttpSession session) {
        System.out.println("user : "+session.getAttribute("user"));
        return "/FE/join";
    } // join

    @GetMapping("/new")
    String newList() {
        return "/new";
    } // newList

    @GetMapping("/order")
    String order() {
        return "/FE/order";
    }  // order

    @GetMapping("/sale")
    String sale() {
        return "/FE/sale";
    } // sale

    @PostMapping("/login")
    String loginOk() {
        return "/FE/login";
    } // loginOk

    @GetMapping("/domesticBrand")
    String domesticBrand() {

        return "/category/domesticBrand";
    } // newList

}
