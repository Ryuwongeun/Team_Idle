package com.idle.shoppingmall.Controller.ControllerView.ProductViews;

import com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO.ProductDetailViewDTO;
import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.Service.Product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductDetailViewController {
    private final ProductService productService;

    @GetMapping("/product/")
    public String showDetailPage(@RequestParam Long id, Model model){
        ProductDetailViewDTO product = productService.findViewById(id);
        if(product.getProduct_img()==null){
            product.setProduct_img("");
        }

        model.addAttribute("data", product);
        return "/product_info";
    }
}
