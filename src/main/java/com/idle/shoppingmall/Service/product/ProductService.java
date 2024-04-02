package com.idle.shoppingmall.Service.product;


import com.idle.shoppingmall.Entity.Key.ProductKey;
import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.mapper.Product.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    @Transactional
    public Long addProduct(Product productDTO) {
        return productMapper.saveProduct(productDTO);
    } // addProduct


    public Product findById(Long productId) {
        return productMapper.findById(new ProductKey(productId));
    }

    public List<Product> findAllProducts() {
        return productMapper.findAllProducts();
    }
} // end class
