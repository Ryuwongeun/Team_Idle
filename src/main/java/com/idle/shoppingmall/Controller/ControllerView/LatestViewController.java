package com.idle.shoppingmall.Controller.ControllerView;

import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.ResponseDTO.Product.ProductCommentListResponse;
import com.idle.shoppingmall.ResponseDTO.Product.ProductSellCountResponse;
import com.idle.shoppingmall.ResponseDTO.Product.ProductListResponse;
import com.idle.shoppingmall.Service.Product.ProductService;
import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class LatestViewController {
    private  final ProductService productService;
    private final int PAGESIZE = 12;


    @PostMapping("/view/GET/Latest")
    public List<ProductListResponse> findAllByLatestDesc(@RequestParam(defaultValue = "1") int page){
        int startPage = (page-1)*PAGESIZE;
        System.out.println("startPage : "+startPage);
        int endPage = PAGESIZE;
        System.out.println("endPage : "+endPage);
        List<ProductListResponse> list = productService.findAllByLatestDesc(startPage, endPage);
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
        System.out.println("startPage : "+startPage);
        int endPage = PAGESIZE;
        System.out.println("pageSize : " + endPage);
        List<Product> productsWithPriceDown = productService.findAllByPdPriceDown(startPage,endPage);
        System.out.println("size : " + productsWithPriceDown.size());
        return productsWithPriceDown;

    }

    @PostMapping("/view/GET/love")
    public List<ProductListResponse>findAllByLoveCountDesc(@RequestParam(defaultValue = "0") int page){
        int startPage = (page)*PAGESIZE;
        int endPage = PAGESIZE;
        List<Product> productLatest = productService.findAllByLoveCountDesc(startPage,endPage);
        List<ProductListResponse> list = new ArrayList<>();
        for(Product product : productLatest) {
            list.add(new ProductListResponse(200, "성공", product.getProduct_id(), product.getPd_name(),
                    product.getPd_price(), product.getPd_category(), product.getCreated_who(),
                    product.getCreated_at(), product.getCount_love()));
        }
        return list;
    }


    //댓글순
    @PostMapping("/view/GET/commentLatest")
    public List<ProductCommentListResponse> findAllByComment(@RequestParam(defaultValue = "0") int page){
        int startPage = (page-1)*PAGESIZE; // 페이지가 0부터 시작한다면 이렇게 수정
        System.out.println("startPage : "+startPage);
        int endPage = PAGESIZE;
        System.out.println("endPage : "+endPage);
        List<ProductCommentListResponse> list = productService.findAllByComment(startPage, endPage); // 매개변수명 변경에 주의
        System.out.println("list size : "+list.size());
        return list;
    }
}
