package com.idle.shoppingmall.ControllerAPI;

import com.idle.shoppingmall.Entity.Test;
import com.idle.shoppingmall.RequestDTO.TestAddRequest;
import com.idle.shoppingmall.ResponseDTO.Test.TestAddResponse;
import com.idle.shoppingmall.Service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestApiController {
    private final TestService testService;

    @PostMapping("/addTest")
    public ResponseEntity<TestAddResponse> addTest(@RequestBody TestAddRequest request) {
        if(request.getId() == null || request.getName() == null)
            return ResponseEntity.ok().body(new TestAddResponse(400, "입력값이 부족해요!!", null));
        testService.addTest(Test.builder()
                .id(request.getId())
                .name(request.getName())
                .build());
        return ResponseEntity.ok().body(new TestAddResponse(200, "입력에 성공했어요!!", request.getName()));
    }
}
