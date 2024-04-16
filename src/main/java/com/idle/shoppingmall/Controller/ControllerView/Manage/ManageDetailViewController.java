package com.idle.shoppingmall.Controller.ControllerView.Manage;

import com.idle.shoppingmall.ResponseDTO.Manage.MProductDetailView;
import com.idle.shoppingmall.Service.Manage.View.MProductDetailViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ManageDetailViewController {
    private final MProductDetailViewService detailService;
    @GetMapping("/manage/product/")
    public String getProudctDetail(@RequestParam Long id, Model model) {
        MProductDetailView response = detailService.getDetail(id);
        model.addAttribute("data", response);
        System.out.println("data : " + response.getDetails());
        return "/Manage/ManageDetail";
    }

    @GetMapping("/manage/newProduct")
    public String newProduct() {
        return "/Manage/AddProduct";
    }
}
