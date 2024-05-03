package com.idle.shoppingmall.Controller.ControllerView;

import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.ResponseDTO.Product.ProductCommentListResponse;
import com.idle.shoppingmall.ResponseDTO.Product.ProductSellCountResponse;
import com.idle.shoppingmall.ResponseDTO.Product.ProductListResponse;
import com.idle.shoppingmall.Service.Product.ProductService;
import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class LatestViewController {
    private  final ProductService productService;
    private final int PAGESIZE = 24;


    @PostMapping("/view/GET/Latest")
    public List<ProductListResponse> findAllByLatestDesc(@RequestParam(defaultValue = "1") int page){
        int startPage = (page-1)*PAGESIZE;
        System.out.println("startPage : "+startPage);
        int endPage = PAGESIZE;
        System.out.println("endPage : "+endPage);

        List<ProductListResponse> list = productService.findAllByLatestDesc(startPage, endPage).stream()
                .map(product -> {
                    product.setProduct_img(product.getProduct_img() == null ?
                    "337d121b-6070-4ae1-a60f-db8a3ede8c21" : product.getProduct_img());
                    return product;
                })
                .toList();

        System.out.println("list : " + list);
        return list; // List<ProductListResponse> 객체를 직접 반환
    }


    //판매 많은 순
    @PostMapping("/view/GET/sellCount")
    public List<ProductSellCountResponse> findAllBySellCountDesc(@RequestParam(defaultValue = "1") int page) {
        int startPage = (page-1)*PAGESIZE;
        System.out.println("startPage : "+startPage);
        int endPage = PAGESIZE;
        System.out.println("endPage : "+endPage);
        List<ProductSellCountResponse> productsWithSellCount = productService.findAllBySellCountDesc(startPage, endPage);
        System.out.println("size : "+productsWithSellCount.size());
        return productsWithSellCount;
    }


    //가격순
    @PostMapping("/view/GET/productLatestPriceDown")
    public List<Product> findAllByPdPriceDown(@RequestParam(defaultValue = "1") int page){
        int startPage = (page-1) * PAGESIZE;
        int endPage = PAGESIZE;
        List<Product> productsWithPriceDown = productService.findAllByPdPriceDown(startPage,endPage);
        System.out.println("size : " + productsWithPriceDown.size());
        return productsWithPriceDown;

    }

    @PostMapping("/view/GET/love")
    public List<ProductListResponse>findAllByLoveCountDesc(@RequestParam(defaultValue = "1") int page){
        int startPage = (page-1)*PAGESIZE;
        int endPage = PAGESIZE;
        List<Product> productLatest = productService.findAllByLoveCountDesc(startPage,endPage);
        List<ProductListResponse> list = new ArrayList<>();
        for(Product product : productLatest) {
            list.add(new ProductListResponse(product.getProduct_id(), product.getProduct_name(),
                    product.getProduct_price(), product.getCount_love(), product.getProduct_img()));
        }
        return list;
    }


    //댓글순
    @PostMapping("/view/GET/commentLatest")
    public List<ProductCommentListResponse> findAllByComment(@RequestParam(defaultValue = "1") int page){
        int startPage = (page-1)*PAGESIZE; // 페이지가 0부터 시작한다면 이렇게 수정
        System.out.println("startPage : "+startPage);
        int endPage = PAGESIZE;
        System.out.println("endPage : "+endPage);
        List<ProductCommentListResponse> list = productService.findAllByComment(startPage, endPage); // 매개변수명 변경에 주의
        System.out.println("list size : "+list.size());
        return list;
    }

    @GetMapping("/view/GET/category")
    public List<ProductListResponse> findByCategory(@RequestParam("category") String pd_category, @RequestParam(defaultValue = "1") int page) {
        List<Product> productList = productService.findByCategory(pd_category);
        List<ProductListResponse> responseList = productList.stream()
                .map(product -> new ProductListResponse(product.getProduct_id(), product.getProduct_name(),
                        product.getProduct_price(), product.getCount_love(), product.getProduct_img()))
                .collect(Collectors.toList());
        return responseList; // JSON 형태로 데이터 반환
    }
}
