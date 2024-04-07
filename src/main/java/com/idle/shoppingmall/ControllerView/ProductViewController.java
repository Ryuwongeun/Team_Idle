package com.idle.shoppingmall.ControllerView;

import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.ResponseDTO.Product.ProductListResponse;
import com.idle.shoppingmall.Service.Product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController // @Controller 대신 @RestController 사용
@RequiredArgsConstructor
public class  ProductViewController {
    private final ProductService productService;


    @PostMapping("/api/GET/productList")
    public List<ProductListResponse> productList(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size) {
        List<Product> productList = productService.findAllProductsPaged(page, size);
        List<ProductListResponse> list = new ArrayList<>();
        for(Product product : productList) {
            String brandName = (product.getBrand() != null) ? product.getBrand().getBrand_name() : "브랜드 없음";
            list.add(new ProductListResponse(666, "성공", product.getProduct_id(), product.getPd_name(),
                    product.getPd_price(), brandName, product.getPd_category(), product.getCreated_who(),
                    product.getCreated_at(), product.getCount_love()));
        }
        System.out.println("list : " + list.get(0).getProduct_id());
        return list; // List<ProductListResponse> 객체를 직접 반환
    }
}


