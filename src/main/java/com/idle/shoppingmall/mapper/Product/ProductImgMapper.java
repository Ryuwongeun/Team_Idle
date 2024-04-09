package com.idle.shoppingmall.mapper.Product;

import com.idle.shoppingmall.Entity.Product.ProductImg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductImgMapper {
    Integer saveProductImg(@Param("img") List<ProductImg> img);

    List<ProductImg> getImgByProduct(@Param("id")Long id);
}
