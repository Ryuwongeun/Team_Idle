package com.idle.shoppingmall.Service;


import com.idle.shoppingmall.Entity.Product;
import com.idle.shoppingmall.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    @Transactional
    public void addProduct(Product productDTO) {
        productMapper.saveProduct(productDTO);
    } // addProduct



    public List<Product> findAllProducts() {
        return productMapper.findAllProducts();
    }
} // end class
