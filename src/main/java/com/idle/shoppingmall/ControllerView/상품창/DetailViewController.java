package com.idle.shoppingmall.ControllerView.상품창;


import com.idle.shoppingmall.Entity.Key.ProductInfoKey;
import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.Service.Product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class DetailViewController {

    private final ProductService productService;

    @GetMapping("/product_info/")
    public String productDetailList(@RequestParam ProductInfoKey key, Model model) {
        Product data = productService.findByProduct(key);
        model.addAttribute("data", data);
        return "/FE/product_info";
    }
}
