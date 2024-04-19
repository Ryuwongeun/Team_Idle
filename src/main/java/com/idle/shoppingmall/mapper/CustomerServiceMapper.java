package com.idle.shoppingmall.mapper;

import com.idle.shoppingmall.Entity.CSEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CustomerServiceMapper {
    Integer addCustomerService(@Param("data") CSEntity data);
}
