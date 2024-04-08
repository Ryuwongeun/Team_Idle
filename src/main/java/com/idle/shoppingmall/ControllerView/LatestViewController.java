package com.idle.shoppingmall.ControllerView;

import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.Service.Product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LatestViewController {
    private  final ProductService productService;

    //최신순
    @GetMapping("/api/GET/productLatest")
    public List<Product> findAllByCreatedAtDesc(){
        return productService.findAllByCreatedAtDesc();
    }

    //가격순
    @GetMapping("/api/GET/productLatestPriceUp")
    public List<Product> findAllByPdPriceDescUp(){
        return productService.findAllByPdPriceDescUp();
    }

    @GetMapping("/api/GET/productLatestPriceDown")

    public List<Product> findAllByPdPriceDescDown(){
        return productService.findAllByPdPriceDescDown();
    }
}