package com.idle.shoppingmall.Controller.ControllerView;

import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.ResponseDTO.Product.ProductSellCountResponse;
import com.idle.shoppingmall.ResponseDTO.Product.ProductListResponse;
import com.idle.shoppingmall.Service.CommentService;
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
    private  final CommentService commentService;
    private final int PAGESIZE = 12;


    //가격순
    @PostMapping("/view/POST/productLatestPriceDown")
    public List<ProductListResponse> findAllByPdPriceDown(@RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "12") int size){
        List<Product> productLatest = productService.findAllByPdPriceDown(page, size);
        List<ProductListResponse> list = new ArrayList<>();
        for(Product product : productLatest) {
            list.add(new ProductListResponse(666, "성공", product.getProduct_id(), product.getPd_name(),
                    product.getPd_price(), product.getPd_category(), product.getCreated_who(),
                    product.getCreated_at(), product.getCount_love()));
        }
        return list;
    }

    @PostMapping("/view/POST/love")
    public List<ProductListResponse>findAllByLoveCountDesc(@RequestParam(defaultValue = "0") int page){
        int startPage = (page-1)*PAGESIZE;
        int endPage = startPage+PAGESIZE;
        List<Product> productLatest = productService.findAllByLoveCountDesc(startPage,endPage);
        List<ProductListResponse> list = new ArrayList<>();
        for(Product product : productLatest) {
            list.add(new ProductListResponse(666, "성공", product.getProduct_id(), product.getPd_name(),
                    product.getPd_price(), product.getPd_category(), product.getCreated_who(),
                    product.getCreated_at(), product.getCount_love()));
        }
        return list;
    }
    //최신순
    @PostMapping("/view/POST/CreatedAt")
    public List<Product> findAllByCreatedAtDesc(@RequestParam(defaultValue = "0") int page){
        int startPage = (page-1) * PAGESIZE;
        System.out.println("startPage : "+startPage);
        int pageSize = PAGESIZE; // 변수 이름을 'endPage'에서 'pageSize'로 변경하여, 페이지 크기를 명확히 함.
        System.out.println("pageSize : "+pageSize);
        List<Product> productsWithCreatedAt = productService.findAllByCreatedAtDesc(startPage, pageSize);
        System.out.println("size : "+ productsWithCreatedAt.size());
        return productsWithCreatedAt; // List<ProductListResponse> 객체를 직접 반환
    }


    //판매 많은 순
    @PostMapping("/view/GET/sellCount")
    public List<ProductSellCountResponse> findAllBySellCountDesc(@RequestParam(defaultValue = "0") int page) {
        int startPage = (page-1)*PAGESIZE;
        System.out.println("startPage : "+startPage);
        int endPage = PAGESIZE;
        System.out.println("endPage : "+endPage);
        List<ProductSellCountResponse> productsWithSellCount = productService.findAllBySellCountDesc(startPage, endPage);
        System.out.println("size : "+productsWithSellCount.size());
        return productsWithSellCount;
    }

    //댓글순
    /*@GetMapping("/view/GET/commentLatest/")
    public List<Comment> findAllByComment() {
        return commentService.findAllByComment();
    }
    */
//    @PostMapping("/view/POST/commentLatest/")
//    public List<ProductListResponse> findAllByComment(@RequestParam(defaultValue = "0") int page,
//                                          @RequestParam(defaultValue = "12") int size) {
//        List<Comment> findAllByComment = commentService.findAllByComment();
//        List<ProductListResponse> list = new ArrayList<>();
//        for(Product product : productLatest) {
//            list.add(new ProductListResponse(666, "성공", product.getProduct_id(), product.getPd_name(),
//                    product.getPd_price(), product.getPd_category(), product.getCreated_who(),
//                    product.getCreated_at(), product.getCount_love()));
//        }
//        return list;
//    }

}
