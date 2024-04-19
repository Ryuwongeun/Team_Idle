package com.idle.shoppingmall.Controller.ControllerView.Manage;

import com.idle.shoppingmall.ResponseDTO.Manage.MProductListView;
import com.idle.shoppingmall.Service.Manage.View.MProductService;
import com.idle.shoppingmall.mapper.Manage.DTO.MProductSortAndOrder;
import com.idle.shoppingmall.mapper.Manage.DTO.ProductSortRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ManageViewController {
    private final int PAGINGSIZE = 10;
    private final MProductService mProductService;

    @GetMapping("/manage")
    public String ManagePageLoad() {
        return "/Manage/ManageMain";
    }

    @PostMapping("/GET/manage/product")
    public ResponseEntity<List<MProductListView>> getProduct() {
        List<MProductListView> products = mProductService.getList(0, PAGINGSIZE);
        return ResponseEntity.ok().body(products);
    }


    @PostMapping("/GET/manage/brand")
    public ResponseEntity<List<MProductListView>> getBrand() {
        List<MProductListView> products = mProductService.getList(0, PAGINGSIZE);
        return ResponseEntity.ok().body(products);
    }

    @PostMapping("/GET/manage/product/search")
    public ResponseEntity<List<MProductListView>> getProductByName(
            @ModelAttribute ProductSortRequest request) {
        int id = request.getId();
        String product_name = request.getProduct_name();
        System.out.println("search name : " + product_name);
        String order = null;
        if (id > 0) {
            if (id == 1) {
                order = "price DESC";
            }
            if (id == 2) {
                order = "amount DESC";
            }
            if (id == 3) {
                order = "sales DESC";
            }
        } else {
            if (id == -1) {
                order = "price ASC";
            }
            if (id == -2) {
                order = "amount ASC";
            }
            if (id == -3) {
                order = "sales ASC";
            }
        }
        System.out.println(order);
        MProductSortAndOrder data = new MProductSortAndOrder(product_name, order, 0, 10);
        List<MProductListView> list = mProductService.sortAndSearch(data);

        return ResponseEntity.ok().body(list);
    }

}