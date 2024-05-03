package com.idle.shoppingmall.Controller.ControllerView;

import com.idle.shoppingmall.Entity.User.UserInfo;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonViewController {

    @GetMapping("/Common/SideMenu")
    String sideMenu() {
        return "/Common/SideMenu";
    } // sideMenu
    @GetMapping("/Common/Search")
    String search() {
        return "/Common/Search";
    } // Topsearch
    @GetMapping("/Common/TopMenu")
    String TopMenu() {
        return "/Common/TopMenu";
    } // TopMenu
    @GetMapping("/Common/Footer")
    String Footer() {
        return "/Common/Footer";
    } // Footer
    @GetMapping("/Common/SizeTable")
    String SizeTable(){
        return "/Common/SizeTable";
    }


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

    @GetMapping("/cs")
    String CS(@RequestParam Long id, Model model, HttpSession session) {
        UserInfo user = (UserInfo) session.getAttribute("user");
        if(user == null) { return "/login"; }
        model.addAttribute("user_name", user.getName());
        model.addAttribute("payment_id", id);
        return "/FE/cs";
    } // CS
//
//    @PostMapping("/login")
//    String loginOk() {
//        return "/FE/login";
//    } // loginOk

    @GetMapping("/category")
    String domesticBrand() {

        return "/category/category";
    } // newList

}
