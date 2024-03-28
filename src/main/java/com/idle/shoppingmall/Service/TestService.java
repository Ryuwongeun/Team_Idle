package com.idle.shoppingmall.Service;

import com.idle.shoppingmall.Entity.Test;
import com.idle.shoppingmall.mapper.TestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestMapper testMapper;

    @Transactional
    public void addTest(Test testDTO) {
        testMapper.save(testDTO);
    }

    @Transactional
    public List<Test> getTestList(){
        return testMapper.findAll();
    }

}
