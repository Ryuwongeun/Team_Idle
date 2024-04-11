package com.idle.shoppingmall.Controller.ControllerAPI.Product;

import com.idle.shoppingmall.Entity.Product.ProductDetail;
import com.idle.shoppingmall.Entity.Product.ProductLog;
import com.idle.shoppingmall.RequestDTO.Product.Add.ProductLogAddRequest;
import com.idle.shoppingmall.ResponseDTO.Product.ProductLogAddResponse;
import com.idle.shoppingmall.Service.Product.ProductDetailService;
import com.idle.shoppingmall.Service.Product.ProductLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductLogApiController {
    private final ProductDetailService productDetailService;
    private final ProductLogService productLogService;


    @PostMapping("/api/POST/addProductLog")
    public ResponseEntity<ProductLogAddResponse>addProductLog(@RequestBody ProductLogAddRequest request) {
        ProductDetail productDetail = productDetailService.findDetail(request.getProduct_id(), request.getSize());

        if(productDetail == null)
            return ResponseEntity.ok().body(new ProductLogAddResponse(400, "물품이 없습니다.", null));

        productLogService.addProductLog(
                ProductLog.builder()
                        .product_id(request.getProduct_id())
                        .size(request.getSize())
                        .count(request.getCount())
                        .created_who(1L)
                        .build()
        );

        return ResponseEntity.ok().body(new ProductLogAddResponse(200, "성공", request.getProduct_id(), request.getSize()));
    }
}
