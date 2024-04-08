package com.idle.shoppingmall.ControllerAPI.User;

import com.idle.shoppingmall.Entity.User.UserAccount;
import com.idle.shoppingmall.Entity.User.UserInfo;
import com.idle.shoppingmall.RequestDTO.User.김승원추가.CheckNameDTO;
import com.idle.shoppingmall.RequestDTO.User.김승원추가.UserJoinRequest;
import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import com.idle.shoppingmall.Service.User.김승원추가.UserJoinService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserJoinApiController {
    private final UserJoinService userJoinService;

    @PostMapping("/api/POST/checkName")
    public ResponseEntity<CommonResponse> checkName(@RequestBody @Valid CheckNameDTO request){
        UserInfo userInfo = userJoinService.getUserInfoByName(request.getName());
        if(userInfo!= null){
            return ResponseEntity.ok().body(new CommonResponse(-1, "이미 존재하는 이름입니다"));
        }
        return ResponseEntity.ok().body(new CommonResponse(200, "사용할 수 있는 이름입니다."));
    }

    @PostMapping("/api/POST/join")
    public ResponseEntity<CommonResponse> joinUser(@RequestBody @Valid UserJoinRequest request){
        System.out.println("joinUser");
        UserAccount userAccount = userJoinService.getUserAccountByEmail(request.getEmail());
        if(userAccount!= null){
            return ResponseEntity.ok().body(new CommonResponse(-1, "이미 존재하는 이메일입니다"));
        }
        UserInfo userInfo = userJoinService.getUserInfoByName(request.getName());
        if(userInfo!= null){
            return ResponseEntity.ok().body(new CommonResponse(-1, "이미 존재하는 이름입니다"));
        }
        Integer id = userJoinService.joinUser(request);
        if(id==null){
            return ResponseEntity.ok().body(new CommonResponse(600, "회원가입 실패"));
        }
        return ResponseEntity.ok().body(new CommonResponse(200, "회원가입 성공"));
    }

}
