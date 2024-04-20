package com.idle.shoppingmall.Controller.ControllerView.Manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MCommonViewController {
    @GetMapping("/manage/Common/TopMenu")
    String search() {
        return "/Common/Manage/TopMenu";
    } // TopMenu
}
