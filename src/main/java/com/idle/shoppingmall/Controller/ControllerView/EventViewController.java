package com.idle.shoppingmall.Controller.ControllerView;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class EventViewController {

    @GetMapping("/FE/event")
    String event() {

        return "/FE/event";
    } // event

} // end class
