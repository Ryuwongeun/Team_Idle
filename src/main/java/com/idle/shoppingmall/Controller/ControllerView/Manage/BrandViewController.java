package com.idle.shoppingmall.Controller.ControllerView.Manage;

import com.idle.shoppingmall.ResponseDTO.Manage.MBrandListResponse;
import com.idle.shoppingmall.Service.Manage.View.MBrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BrandViewController {
    private final MBrandService brandService;
    private final int PAGINGSIZE = 10;

    @PostMapping("/GET/manage/brand/search")
    public ResponseEntity<List<MBrandListResponse>> getBrandList(@RequestParam(required = false, defaultValue = "") String name,
                                                                   @RequestParam int page){
        int paging = page * PAGINGSIZE;
        return ResponseEntity.ok().body(brandService.getBrandDetails());
    }
}
