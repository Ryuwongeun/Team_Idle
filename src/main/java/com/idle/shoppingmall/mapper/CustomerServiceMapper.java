package com.idle.shoppingmall.mapper;

import com.idle.shoppingmall.Entity.CSEntity;
import com.idle.shoppingmall.ResponseDTO.Manage.MCSListRepsonse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerServiceMapper {
    Integer addCustomerService(@Param("data") CSEntity data);

    List<MCSListRepsonse> getCSList(@Param("name") String name, @Param("size") int size, @Param("offset") int offset);
}
