package com.idle.shoppingmall.Controller.ControllerView.Manage;

import com.idle.shoppingmall.ResponseDTO.Manage.MBrandListResponse;
import com.idle.shoppingmall.ResponseDTO.Manage.MCSListRepsonse;
import com.idle.shoppingmall.Service.Manage.View.MCSService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CSListViewController {
    private final int PAGINGSIZE = 10;
    private final MCSService csService;

    @PostMapping("/manage/GET/cs/search")
    public ResponseEntity<List<MCSListRepsonse>> getBrandList(@RequestParam(required = false, defaultValue = "") String name,
                                                              @RequestParam(defaultValue = "1") int page){
        int startPage = page * PAGINGSIZE;
        int endPage = PAGINGSIZE;
        List<MCSListRepsonse> list = csService.getCSList(name, startPage, endPage);
        return ResponseEntity.ok().body(csService.getCSList(name, startPage, endPage));
    }

}
