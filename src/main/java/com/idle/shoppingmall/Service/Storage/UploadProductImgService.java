package com.idle.shoppingmall.Service.Storage;

import com.idle.shoppingmall.Entity.Product.ProductImg;
import com.idle.shoppingmall.mapper.Product.ProductImgMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UploadProductImgService {

    private final ProductImgMapper mapper;

    @Transactional
    public void upload(List<ProductImg> imgList) {
        mapper.saveProductImg(imgList);
    }
}
