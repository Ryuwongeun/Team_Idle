package com.idle.shoppingmall.Service;


import com.idle.shoppingmall.Entity.Product;
import com.idle.shoppingmall.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    @Transactional
    public void addProduct(Product productDTO) {
        productMapper.saveProduct(productDTO);
    } // addProduct

} // end class
