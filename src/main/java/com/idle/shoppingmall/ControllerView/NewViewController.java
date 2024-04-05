package com.idle.shoppingmall.ControllerView;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class NewViewController {

    @GetMapping("/FE/new")
    String newList() {

        return "/FE/new";
    } // newList

} // end class
