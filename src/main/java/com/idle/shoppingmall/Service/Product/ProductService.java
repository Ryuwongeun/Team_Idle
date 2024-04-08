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

    public List<Product> findAllProductsPaged(int page, int size) {
        int offset = page * size; // 페이지 번호와 사이즈를 곱하여 offset 계산
        return productMapper.findAllProductsPaged(size, offset);
    }

    public List<Product> findAllByCreatedAtDesc() {
        return productMapper.findAllByCreatedAtDesc();
    }

    public List<Product> findAllByPdPriceDescUp() {
        return productMapper.findAllByPdPriceDescUp();
    }

    public List<Product> findAllByPdPriceDescDown() {
        return productMapper.findAllByPdPriceDescDown();
    }
} // end class
