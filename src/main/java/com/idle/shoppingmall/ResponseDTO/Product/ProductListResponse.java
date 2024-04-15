package com.idle.shoppingmall.ResponseDTO.Product;

import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class ProductListResponse extends CommonResponse {
    private Long product_id;
    private String pd_name;
    private int pd_price;
    private String pd_category;
    private Long created_who;
    private LocalDateTime created_at;
    private int count_love;


    public ProductListResponse(int code, String msg, Long product_id, String pd_name, int pd_price, String pd_category, Long created_who, LocalDateTime created_at, int count_love) {
        super(code, msg);
        this.product_id = product_id;
        this.pd_name = pd_name;
        this.pd_price = pd_price;
        this.pd_category = pd_category;
        this.created_who = created_who;
        this.created_at = created_at;
        this.count_love = count_love;
    }
}

