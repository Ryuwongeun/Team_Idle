package com.idle.shoppingmall.Controller.ControllerAPI.Product;

import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.RequestDTO.Product.Delete.ProductDeleteRequest;
import com.idle.shoppingmall.RequestDTO.Product.Search.ProductSearchRequest;
import com.idle.shoppingmall.RequestDTO.Product.Update.ProductUpdateRequest;
import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import com.idle.shoppingmall.Service.Product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductApiController {
    private final ProductService productService;

    //상품 수정
    @PostMapping("/api/POST/updateProduct")
    public ResponseEntity<CommonResponse> updateProduct(@RequestBody @Valid ProductUpdateRequest updateRequest) {
        Product product = productService.findById(updateRequest.getProduct_id());
        if(product == null)
            return ResponseEntity.ok().body(new CommonResponse(400, "물품이 없습니다"));
        Integer id= productService.update(
               Product.builder()
                       .product_id(product.getProduct_id())
                       .product_name(updateRequest.getProduct_name())
                       .product_price(updateRequest.getProduct_price())
                       .product_category(updateRequest.getProduct_category())
                       .build()
        );
        if(id==null){
            return ResponseEntity.ok().body(new CommonResponse(400, "수정 실패"));
        }
        return ResponseEntity.ok().body(new CommonResponse(200, "수정 완료"));
    }

    //상품 삭제
    @PostMapping("/api/POST/deleteProduct")
    public ResponseEntity<CommonResponse> deleteProduct(@RequestBody @Valid ProductDeleteRequest deleteRequest) {
        Product product = productService.findById(deleteRequest.getProduct_id());
        if(product == null)
            return ResponseEntity.ok().body(new CommonResponse(400, "물품이 없습니다."));

        Integer id = productService.delete(deleteRequest.getProduct_id());
        if(id == null)
            return ResponseEntity.ok().body(new CommonResponse(400, "삭제 실패!!."));
        return ResponseEntity.ok().body(new CommonResponse(200, "삭제 되었습니다."));
    }

    //상품 검색
    @PostMapping("/api/POST/searchProduct")
    public ResponseEntity<?> searchProduct(@RequestBody @Valid ProductSearchRequest request) {
        List<Product> list = productService.findAllByPdName(request.getProduct_name());
        return ResponseEntity.ok(list); // JSON 형태로 응답
    }
}