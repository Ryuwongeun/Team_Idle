package com.idle.shoppingmall.Controller.ControllerAPI.Product;

import com.idle.shoppingmall.Entity.Brand;
import com.idle.shoppingmall.RequestDTO.Product.Search.BrandSearchRequest;
import com.idle.shoppingmall.ResponseDTO.Product.BrandListResponse;
import com.idle.shoppingmall.Service.Product.BrandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BrandApiController {
    private final BrandService brandService;

    private final int PAGESIZE = 10;
    @PostMapping("/manage/GET/brand")
    public ResponseEntity<List<BrandListResponse>> getBrandByName(@RequestBody @Valid BrandSearchRequest request, @RequestParam(defaultValue = "1")int page) {
        int startPage = (page-1)*PAGESIZE;
        int endPage = PAGESIZE;
        List<BrandListResponse> brands = brandService.findByName(request.getBrand_name(),startPage,endPage);
        return ResponseEntity.ok().body(brands);
    }
}
