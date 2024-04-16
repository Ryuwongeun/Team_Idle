package com.idle.shoppingmall.Controller.ControllerView;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class BestViewController {

    @GetMapping("/best")
    String bestList() {

        return "/FE/best";
    } // bestList

    @GetMapping("/like")
    String likeList() {

        return "/like";
    } // likeList

    @GetMapping("/comment")
    String commentList() {

        return "/comment";
    } // commentList

} // end class
