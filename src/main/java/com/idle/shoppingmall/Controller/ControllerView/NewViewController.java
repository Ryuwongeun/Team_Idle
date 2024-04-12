package com.idle.shoppingmall.Controller.ControllerView;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class NewViewController {

    @GetMapping("/FE/new")
    String newList() {

        return "/new";
    } // newList

} // end class
