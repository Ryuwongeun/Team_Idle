package com.idle.shoppingmall.ControllerAPI.Product;

import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.Entity.Product.ProductDetail;
import com.idle.shoppingmall.RequestDTO.Product.ProductDetailAddRequest;

import com.idle.shoppingmall.ResponseDTO.Product.ProductDetailAddResponse;
import com.idle.shoppingmall.Service.product.ProductDetailService;
import com.idle.shoppingmall.Service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductDetailApiController {
    private final ProductService productService;
    private final ProductDetailService productDetailService;
    @PostMapping("api/POST/addProductDetail")
    public ResponseEntity<ProductDetailAddResponse> addProductDetail(@RequestBody ProductDetailAddRequest request) {
        Product product = productService.findById(request.getProduct_id());

        if(product == null)
            return ResponseEntity.ok().body(new ProductDetailAddResponse(200, "물품이 없습니다.", (Long) null));

        productDetailService.addProductDetail(
                ProductDetail.builder()
                        .product_id(request.getProduct_id())
                        .size(request.getSize())
                        .pd_before_count(request.getPd_before_count())
                        .pd_sell_count(0)
                        .build()
        );

        return ResponseEntity.ok().body(new ProductDetailAddResponse(100, "성공", request.getProduct_id(), request.getSize(), request.getPd_sell_count()));
    }
}
