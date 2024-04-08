package com.idle.shoppingmall.ControllerAPI.Product;

import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.RequestDTO.Product.Add.ProductAddRequest;
import com.idle.shoppingmall.RequestDTO.Product.Delete.ProductDeleteRequest;
import com.idle.shoppingmall.RequestDTO.Product.Update.ProductUpdateRequest;
import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import com.idle.shoppingmall.ResponseDTO.Product.ProductAddResponse;
import com.idle.shoppingmall.Service.Product.ProductService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
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
            return ResponseEntity.ok().body(new ProductAddResponse(400, "상품 이름 또는 가격이 유효하지 않습니다.", null));
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

    @PostMapping("/api/POST/updateProduct")
    public ResponseEntity<CommonResponse> updateProduct(@RequestBody @Valid ProductUpdateRequest updateRequest) {
        Product product = productService.findById(updateRequest.getProduct_id());
        if(product == null)
            return ResponseEntity.ok().body(new CommonResponse(400, "물품이 없습니다"));

        Integer id= productService.update(
               Product.builder()
                       .product_id(updateRequest.getProduct_id())
                       .pd_name(updateRequest.getPd_name())
                       .pd_price(updateRequest.getPd_price())
                       .pd_category(updateRequest.getPd_category())
                       .build()
        );
        if(id==null){
            return ResponseEntity.ok().body(new CommonResponse(400, "수정 실패"));
        }
        return ResponseEntity.ok().body(new CommonResponse(200, "수정 완료"));
    }

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

    //최신순
    @GetMapping("/api/GET/productLatest")
    public List<Product> findAllByCreatedAtDesc(){
        return productService.findAllByCreatedAtDesc();
    }

    //가격순
    @GetMapping("/api/GET/productLatestPriceUp")
    public List<Product> findAllByPdPriceDescUp(){
        return productService.findAllByPdPriceDescUp();
    }

    @GetMapping("/api/GET/productLatestPriceDown")
    public List<Product> findAllByPdPriceDescDown(){
        return productService.findAllByPdPriceDescDown();
    }
}
