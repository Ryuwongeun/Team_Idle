package com.idle.shoppingmall.Service.Product;

import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.Entity.Product.ProductDetail;
import com.idle.shoppingmall.RequestDTO.Product.Add.ProductAddRequest;
import com.idle.shoppingmall.Service.Storage.NCPObjectStorageService;
import com.idle.shoppingmall.mapper.Product.ProductDetailMapper;
import com.idle.shoppingmall.mapper.Product.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ProductAddService {
    private final ProductMapper productMapper;
    private final ProductDetailMapper productDetailMapper;
    private final NCPObjectStorageService ncpObjectStorageService;

    private final String BUCKETNAME = "miniidle";


    @Transactional
    public Long addProduct(ProductAddRequest request, Long id){
        String imageFileName = request.getThumbnail() == null ? null :
                ncpObjectStorageService.uploadFile(BUCKETNAME, "storage/", request.getThumbnail());
        Product product = Product.builder()
                .product_name(request.getProduct_name())
                .brand_id(request.getBrand())
                .product_price(request.getProduct_price())
                .product_category(request.getProduct_category())
                .created_who(id)
                .created_at(LocalDateTime.now())
                .product_img(imageFileName)
                .build();
        productMapper.saveProduct(product);
        Long product_id = product.getProduct_id();


        for(int i=0; i<request.getSizes().size(); i++){
            ProductDetail detail = ProductDetail.builder()
                    .product_id(product_id)
                    .size(request.getSizes().get(i).getSize())
                    .product_before_count(request.getSizes().get(i).getCount())
                    .build();
            productDetailMapper.saveProductDetail(detail);
        }

        if(product_id==0){
            return null;
        }
        else return product_id;
    }
}
