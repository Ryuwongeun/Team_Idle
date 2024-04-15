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
    public Integer addProduct(Product productDTO) {
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

    public List<Product> findAllByCreatedAtDesc(int page, int size) {
        int offset = page * size;
        return productMapper.findAllByCreatedAtDesc(size, offset);
    }

    public List<Product> findAllByPdPriceDown(int page, int size) {
        int offset = page * size;
        return productMapper.findAllByPdPriceDown(size, offset);
    }

    public List<Product>findAllByLoveCountDesc(int page, int size){
        int offset = page * size;
        return productMapper.findAllByLoveCountDesc(size, offset);
    }

    public List<Product> findAllByPdName(String name) {
        return productMapper.findAllByPdName(name);
    }

    @Transactional
    public void increaseLoveCountAndSave(Long productId) {
        Product product = productMapper.findById(productId);
        if (product != null) {
            product.increaseLoveCount();
            productMapper.update(product); // 'update' 메서드 사용
        }
    }

    // 'loveCount' 감소 후 데이터베이스에 저장
    @Transactional
    public void decreaseLoveCountAndSave(Long productId) {
        Product product = productMapper.findById(productId);
        if (product != null) {
            product.decreaseLoveCount();
            productMapper.update(product); // 'update' 메서드 사용
        }
    }

    public List<Product> findAllByComment(int page, int size) {
        int offset = page * size;
        return productMapper.findAllByComment(size, offset);
    }
} // end class
