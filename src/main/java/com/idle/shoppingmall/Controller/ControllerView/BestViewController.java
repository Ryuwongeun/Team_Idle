package com.idle.shoppingmall.Controller.ControllerView;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class BestViewController {

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

} // end class
