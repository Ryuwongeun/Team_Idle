package com.idle.shoppingmall.Controller.ControllerView;

import com.idle.shoppingmall.Entity.Product.Product;
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
    private final CommentService commentService;

    private final int PAGESIZE = 12;

    //최신순
    @PostMapping("/view/POST/productLatest")
    public List<ProductListResponse> productLatest(@RequestParam(defaultValue = "0") int page){
        page = page * PAGESIZE;
        int size = page + PAGESIZE;
        List<Product> productLatest = productService.findAllByCreatedAtDesc(page, size);
        List<ProductListResponse> list = new ArrayList<>();
        for(Product product : productLatest) {
            list.add(new ProductListResponse(200, "성공", product.getProduct_id(), product.getPd_name(),
                    product.getPd_price(), product.getPd_category(), product.getCreated_who(),
                    product.getCreated_at(), product.getCount_love()));
        }
        System.out.println("list : " + list.get(0).getCreated_at());
        return list; // List<ProductListResponse> 객체를 직접 반환
    }

    //가격순
    @PostMapping("/view/POST/productLatestPriceDown")
    public List<ProductListResponse> findAllByPdPriceDown(@RequestParam(defaultValue = "0") int page){
        page = page * PAGESIZE;
        int size = page + PAGESIZE;
        List<Product> productLatest = productService.findAllByPdPriceDown(page, size);
        List<ProductListResponse> list = new ArrayList<>();
        for(Product product : productLatest) {
            list.add(new ProductListResponse(200, "성공", product.getProduct_id(), product.getPd_name(),
                    product.getPd_price(), product.getPd_category(), product.getCreated_who(),
                    product.getCreated_at(), product.getCount_love()));
        }
        return list;
    }

    @PostMapping("/view/POST/love")
    public List<ProductListResponse>findAllByLoveCountDesc(@RequestParam(defaultValue = "0") int page){
        page = page * PAGESIZE;
        int size = page + PAGESIZE;
        List<Product> productLatest = productService.findAllByLoveCountDesc(page, size);
        List<ProductListResponse> list = new ArrayList<>();
        for(Product product : productLatest) {
                list.add(new ProductListResponse(200, "성공", product.getProduct_id(), product.getPd_name(),
                        product.getPd_price(), product.getPd_category(), product.getCreated_who(),
                        product.getCreated_at(), product.getCount_love()));
        }
        return list;
    }

    //댓글순
    @PostMapping("/view/POST/commentLatest/")
    public List<ProductListResponse> findAllByComment(@RequestParam(defaultValue = "0") int page){
        page = page * PAGESIZE;
        int size = page + PAGESIZE;
        List<Product> productLatest = productService.findAllByComment(page, size);
        List<ProductListResponse> list = new ArrayList<>();
        for(Product product : productLatest) {
            list.add(new ProductListResponse(200, "성공", product.getProduct_id(), product.getPd_name(),
                    product.getPd_price(), product.getPd_category(), product.getCreated_who(),
                    product.getCreated_at(), product.getCount_love()));
        }
        return list;
    }
}