package com.idle.shoppingmall.ControllerAPI;

import com.idle.shoppingmall.Entity.User.User_Account;
import com.idle.shoppingmall.RequestDTO.UserAccountAddRequest;
import com.idle.shoppingmall.ResponseDTO.UserAccount.UserAccountAddResponse;
import com.idle.shoppingmall.Service.User.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class UserAccountApiController {
    private final UserAccountService userAccountService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/api/POST/addUserAccount")
    public ResponseEntity<UserAccountAddResponse> addUserAccount(@RequestBody UserAccountAddRequest request){
        if (request.getUser_email() == null) {
            return ResponseEntity.ok().body(new UserAccountAddResponse(400, "XX", null));
        }
        Long id = userAccountService.addUserAccount
                (User_Account.builder()
                        .user_email(request.getUser_email())
                        .user_password(passwordEncoder.encode(request.getUser_password()))
                        .user_pnum(request.getUser_pnum())
                        .last_login(LocalDateTime.now())
                .build()
        );
        if(id==null){
            return ResponseEntity.ok().body(new UserAccountAddResponse(400,"실패",null));
        }

        return ResponseEntity.ok().body(new UserAccountAddResponse(200,"성공", request.getUser_email()));
    }
}
