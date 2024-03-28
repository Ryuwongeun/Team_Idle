package com.idle.shoppingmall.ControllerView;

import com.idle.shoppingmall.Entity.Test;
import com.idle.shoppingmall.ResponseDTO.Test.TestListResponse;
import com.idle.shoppingmall.Service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestViewController {
    private final TestService testService;

    @GetMapping("/test")
    public String test(Model model) {
        List<Test> testList = testService.getTestList();
        List<TestListResponse> list = new ArrayList<>();
        for(int i=0; i<testList.size(); i++) {
            list.add(new TestListResponse(666, "성공", i, testList.get(i).getId(), testList.get(i).getName()));
        }
        model.addAttribute("data", list);
        return "Test/test";
    }
}
