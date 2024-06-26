package com.idle.shoppingmall.Service.Product;

import com.idle.shoppingmall.Entity.Key.LogKey;
import com.idle.shoppingmall.Entity.Product.ProductLog;
import com.idle.shoppingmall.mapper.Product.ProductLogMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductLogService {
    private final ProductLogMapper productLogMapper;

    public void addProductLog(ProductLog productLogDTO) {
        productLogMapper.saveProductLog(productLogDTO);
    }

    public ProductLog findById(Long createdWho, Long product_id, String size) {
        return productLogMapper.findById(new LogKey(createdWho, product_id, size));
    }
}
