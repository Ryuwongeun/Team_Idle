package com.idle.shoppingmall.mapper;

import com.idle.shoppingmall.Entity.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TestMapper {
    void save(@Param("test") Test testDTO);

    List<Test> findAll();
}
