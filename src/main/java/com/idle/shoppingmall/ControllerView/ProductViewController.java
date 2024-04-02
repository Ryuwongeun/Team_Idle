package com.idle.shoppingmall.ControllerView;

import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.ResponseDTO.Product.ProductListResponse;
import com.idle.shoppingmall.Service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductViewController {
    private final ProductService productService;

    @GetMapping("/productList")
    public String productList(Model model){
        List<Product> productList = productService.findAllProducts();
        List<ProductListResponse> list = new ArrayList<>();
        for(Product product : productList){
            list.add(new ProductListResponse(666, "성공",product.getProduct_id(), product.getPd_name(),
                    product.getPd_price(),product.getBrand_id(),product.getPd_category(),product.getCreated_who(),
                    product.getCreated_at(),product.getCount_love()));
        }
        model.addAttribute("data", list); // 수정된 부분: productList 대신 list를 추가
        return "Product/product";
    }
}
