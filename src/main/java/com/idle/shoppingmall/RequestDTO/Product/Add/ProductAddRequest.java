package com.idle.shoppingmall.RequestDTO.Product.Add;


import com.idle.shoppingmall.mapper.Manage.DTO.SizeAndCount;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductAddRequest {
    private String pd_name;
    private Long brand;
    private int pd_price;
    private String pd_category;
    private List<SizeAndCount> sizes;
    private List<MultipartFile> images;
}

