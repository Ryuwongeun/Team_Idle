package com.idle.shoppingmall.RequestDTO.Product.Add;


import com.idle.shoppingmall.mapper.Manage.DTO.SizeAndCount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductAddRequest {
    private String product_name;
    private Long brand;
    private int product_price;
    private String product_category;
    private List<SizeAndCount> sizes;
    private MultipartFile thumbnail;
    private List<MultipartFile> images;
}

