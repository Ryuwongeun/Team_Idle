package com.idle.shoppingmall.mapper;

import com.idle.shoppingmall.Entity.CS.CSAnswer;
import com.idle.shoppingmall.Entity.CS.CSEntity;
import com.idle.shoppingmall.ResponseDTO.Manage.MCSListRepsonse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerServiceMapper {
    Integer addCustomerService(@Param("data") CSEntity data);

    Integer answerCS(@Param("data") CSAnswer data);

    Integer updateCS(@Param("state") String state, @Param("cs_id") Long cs_id);

    String getEmail(@Param("cs_id") Long cs_id);

    List<MCSListRepsonse> getCSList(@Param("name") String name, @Param("size") int size, @Param("offset") int offset);
}
