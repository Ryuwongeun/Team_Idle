package com.idle.shoppingmall.Controller.ControllerView.ProductViews;


import com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO.PaymentListResponse;
import com.idle.shoppingmall.Entity.Key.DetailKey;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PaymentViewContoller {

    @GetMapping("/buy")
    String buy(Model model, HttpSession session) {
        List<PaymentListResponse> keys = session.getAttribute("paymentList") == null ? null : (List<PaymentListResponse>) session.getAttribute("paymentList");
        if(keys==null){
            return "redirect:/login";
        }
        model.addAttribute("data", keys);
        session.removeAttribute("paymentList");
        return "/FE/buy";
    }

}
