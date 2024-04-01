package com.idle.shoppingmall.ControllerAPI;

import com.idle.shoppingmall.Entity.Product;
import com.idle.shoppingmall.RequestDTO.ProductAddRequest;
import com.idle.shoppingmall.ResponseDTO.Product.ProductAddResponse;
import com.idle.shoppingmall.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductApiController {
    private final ProductService productService;

    @PostMapping("/api/POST/addProduct")
    public ResponseEntity<ProductAddResponse> addProduct(@RequestBody ProductAddRequest request) {
        if (request.getPd_name() == null || request.getPd_name().isEmpty() || request.getPd_price() <= 0) {
            return ResponseEntity.badRequest().body(new ProductAddResponse(400, "상품 이름 또는 가격이 유효하지 않습니다.", null));
        }

        Long id = productService.addProduct(
                Product.builder()
                        .brand_id(request.getBrand_id())
                        .pd_name(request.getPd_name())
                        .pd_price(request.getPd_price())
                        .pd_category(request.getPd_category())
                        .created_at(LocalDateTime.now())
                        .build()
        );
        if(id== null) {
            return ResponseEntity.ok().body(new ProductAddResponse(400, "상품 추가에 실패했습니다.", null));
        }
        return ResponseEntity.ok().body(new ProductAddResponse(200, "상품 추가에 성공했습니다.", id.toString()));
    }
}
