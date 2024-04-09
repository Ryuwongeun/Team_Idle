package com.idle.shoppingmall.ControllerView;

import com.idle.shoppingmall.Entity.Comment;
import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.Service.CartService;
import com.idle.shoppingmall.Service.CommentService;
import com.idle.shoppingmall.Service.Product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LatestViewController {
    private  final ProductService productService;
    private  final CommentService commentService;
    private  final CartService cartService;

    //최신순
    @GetMapping("/view/GET/productLatest")
    public List<Product> findAllByCreatedAtDesc(){
        return productService.findAllByCreatedAtDesc();
    }

    //가격순
    @GetMapping("/view/GET/productLatestPriceUp")
    public List<Product> findAllByPdPriceDescUp(){
        return productService.findAllByPdPriceDescUp();
    }

    @GetMapping("/view/GET/productLatestPriceDown")
    public List<Product> findAllByPdPriceDescDown(){
        return productService.findAllByPdPriceDescDown();
    }

    @GetMapping("/view/GET/love")
    public List<Product>findAllByLoveCountDesc(){
        return productService.findAllByLoveCountDesc();
    }

    //댓글순
    @GetMapping("/view/GET/commentLatest/")
    public List<Comment> findAllByComment() {
        return commentService.findAllByComment();
    }
}
