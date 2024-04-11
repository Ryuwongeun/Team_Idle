package com.idle.shoppingmall.ControllerAPI.Product;

import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.Entity.Product.ProductDetail;
import com.idle.shoppingmall.RequestDTO.Product.Add.ProductDetailAddRequest;

import com.idle.shoppingmall.ResponseDTO.Product.ProductDetailAddResponse;
import com.idle.shoppingmall.Service.Product.ProductDetailService;
import com.idle.shoppingmall.Service.Product.ProductService;
import jakarta.validation.Valid;
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
    public ResponseEntity<ProductDetailAddResponse> addProductDetail(@RequestBody @Valid ProductDetailAddRequest request) {
        Product product = productService.findById(request.getId());
        if(product==null){
            return ResponseEntity.ok().body(new ProductDetailAddResponse(400, "물품이 없습니다.", null));
        }
        ProductDetail detail = productDetailService.findDetail(request.getId(), request.getSize());

        detail.updateCount(request.getCount());
        Integer result = productDetailService.updateProductDetail(detail);
        if(result==null){
            return ResponseEntity.ok().body(new ProductDetailAddResponse(600, "수량 추가 실패", request.getId(), request.getSize(), request.getCount()));
        }
        return ResponseEntity.ok().body(new ProductDetailAddResponse(200, "수량 추가 성공", request.getId(), request.getSize(), request.getCount()));
    }
}
