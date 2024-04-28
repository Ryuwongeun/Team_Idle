package com.idle.shoppingmall.Service.Product;


import com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO.ProductDetailViewDTO;
import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.ResponseDTO.Product.ProductCommentListResponse;
import com.idle.shoppingmall.ResponseDTO.Product.ProductListResponse;
import com.idle.shoppingmall.ResponseDTO.Product.ProductSellCountResponse;
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


    public Product findById(Long product_id) {
        return productMapper.findById(product_id);
    }

    public List<Product> findAllProducts() {
        return productMapper.findAllProducts();
    }

    public Integer update(Product productDTO) {
        return productMapper.update(productDTO);
    }

    public Integer delete(Long product_id) {
        return productMapper.delete(product_id);
    }

    public List<Product> findAllProductsPaged(int page, int size) {
        int offset = page * size; // 페이지 번호와 사이즈를 곱하여 offset 계산
        return productMapper.findAllProductsPaged(size, offset);
    }

    public List<ProductListResponse> findAllByLatestDesc(int startPage, int endPage) {
        return productMapper.findAllByLatestDesc(startPage, endPage);
    }

    public List<Product> findAllByPdPriceDown(int page, int size) {
        int offset = page * size;
        return productMapper.findAllByPdPriceDown(size, offset);
    }

    public List<Product>findAllByLoveCountDesc(int startPage, int endPage){
        return productMapper.findAllByLoveCountDesc(startPage, endPage);
    }

    public List<ProductSellCountResponse> findAllBySellCountDesc(int startPage, int endPage) {
        return productMapper.findAllBySellCountDesc(startPage, endPage);
    }
    public List<Product> findAllByPdName(String searchRequest) {
        return productMapper.findAllByPdName(searchRequest);
    }

    @Transactional
    public void increaseLoveCountAndSave(Long product_id) {
        Product product = productMapper.findById(product_id);
        if (product != null) {
            product.increaseLoveCount();
            productMapper.update(product); // 'update' 메서드 사용
        }
    }

    // 'loveCount' 감소 후 데이터베이스에 저장
    @Transactional
    public void decreaseLoveCountAndSave(Long product_id) {
        Product product = productMapper.findById(product_id);
        if (product != null) {
            product.decreaseLoveCount();
            productMapper.update(product); // 'update' 메서드 사용
        }
    }

    public List<ProductCommentListResponse> findAllByComment(int startPage, int endPage) {
        return productMapper.findAllByComment(startPage, endPage);
    }

    public ProductDetailViewDTO findViewById(Long product_id) {
        return productMapper.findViewById(product_id);
    }

    public List<Product> findByCategory(String pdCategory) {
        return productMapper.findByCategory(pdCategory);
    }
} // end class
