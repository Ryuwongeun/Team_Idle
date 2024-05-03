package com.idle.shoppingmall.Controller.ControllerView.Manage;

import com.idle.shoppingmall.ResponseDTO.Manage.MProductDetailView;
import com.idle.shoppingmall.ResponseDTO.Product.BrandListResponse;
import com.idle.shoppingmall.Service.Manage.View.MProductDetailViewService;
import com.idle.shoppingmall.Service.Product.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ManageDetailViewController {
    private final MProductDetailViewService detailService;
    private final BrandService brandService;
    private final int PAGESIZE = 10;
    @GetMapping("/manage/product/")
    public String getProudctDetail(@RequestParam Long id, Model model) {
        MProductDetailView response = detailService.getDetail(id);
        model.addAttribute("data", response);
        System.out.println("data : " + response.getDetails());
        return "/Manage/ManageDetail";
    }

    @GetMapping("/manage/newProduct")
    public String newProduct(@RequestParam(defaultValue = "1") int page, Model model) {
        int startPage = (page-1)*PAGESIZE;
        int endPage = PAGESIZE;
        List<BrandListResponse> list = brandService.findAll(startPage,endPage);
        model.addAttribute("data", list);
        return "/Manage/AddProduct";
    }
}
