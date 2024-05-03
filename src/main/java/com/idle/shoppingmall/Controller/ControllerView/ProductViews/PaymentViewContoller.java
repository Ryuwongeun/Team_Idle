package com.idle.shoppingmall.Controller.ControllerView.ProductViews;


import com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO.PaymentListDTOtoSession;
import com.idle.shoppingmall.ResponseDTO.Payment.PaymentListViewResponse;
import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.Service.Product.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.IntStream;

@Controller
@RequiredArgsConstructor
public class PaymentViewContoller {
    private final ProductService productService;

    @GetMapping("/buy")
    String buy(Model model, HttpSession session) {
        List<PaymentListDTOtoSession> keys = session.getAttribute("paymentList") == null ? null : (List<PaymentListDTOtoSession>) session.getAttribute("paymentList");
        if(keys==null){
            return "redirect:/login";
        }
        List<PaymentListViewResponse> list = IntStream.range(0, keys.size())
                .mapToObj(i -> {
                    Product product =  keys.get(i).getProduct();
                    return new PaymentListViewResponse(product.getProduct_name(), product.getProduct_price(), keys.get(i).getSize(),
                            keys.get(i).getCount(),
                            product.getProduct_img());
                })
                .toList();
        model.addAttribute("data", list);
//        session.removeAttribute("paymentList");
        return "/FE/buy";
    }

}
