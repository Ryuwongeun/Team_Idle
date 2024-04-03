package com.idle.shoppingmall.Service.Product;


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
        return productMapper.findById(productId);
    }

    public List<Product> findAllProducts() {
        return productMapper.findAllProducts();
    }

    public Integer update(Product productDTO) {
        return productMapper.update(productDTO);
    }

    public Integer delete(Long productID) {
        return productMapper.delete(productID);
    }
} // end class
