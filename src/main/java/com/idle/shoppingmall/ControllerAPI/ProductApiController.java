package com.idle.shoppingmall.ControllerAPI;

import com.idle.shoppingmall.Entity.Brand;
import com.idle.shoppingmall.Entity.Product;
import com.idle.shoppingmall.RequestDTO.ProductAddRequest;
import com.idle.shoppingmall.ResponseDTO.Test.ProductAddResponse;
import com.idle.shoppingmall.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class ProductApiController {
    private final ProductService productService;

    @PostMapping("api/POST/addProduct")
    public ResponseEntity<ProductAddResponse> addProduct(@RequestBody ProductAddRequest request){

        if (request.getPd_name() == null) {
            return ResponseEntity.ok().body(new ProductAddResponse(400, "상품이름이 없습니다.", null));
        } else if (request.getPd_price() == 0) {
            return ResponseEntity.ok().body(new ProductAddResponse(400, "가격이 없습니다.", null));
        }

        productService.addProduct(
                Product.builder()
                        .brand_id(request.getBrand_id())
                        .pd_name(request.getPd_name())
                        .pd_price(request.getPd_price())
                        .pd_category(request.getPd_category())
                        .created_at(LocalDateTime.now())
                        .build()
        );

        return ResponseEntity.ok().body(new ProductAddResponse(100, "상품 등록에 성공했습니다.", request.getPd_name()));

    } // saveProduct

} // end class
