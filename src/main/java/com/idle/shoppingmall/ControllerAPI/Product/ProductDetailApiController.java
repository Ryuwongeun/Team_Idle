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

        if(request.getProduct_id() == null)
            return ResponseEntity.ok().body(new ProductDetailAddResponse(200, "일련번호가 없습니다.",(Long) null));
        else if(request.getSize() == null)
            return ResponseEntity.ok().body(new ProductDetailAddResponse(200, "사이즈가 없습니다." , (String) null));
        else if(request.getPd_sell_count() == 0)
            return ResponseEntity.ok().body(new ProductDetailAddResponse(200, "수량이 없습니다", 0));

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
