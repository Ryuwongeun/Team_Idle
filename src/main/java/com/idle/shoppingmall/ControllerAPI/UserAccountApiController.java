package com.idle.shoppingmall.ControllerAPI;

import com.idle.shoppingmall.Entity.User.User_Account;
import com.idle.shoppingmall.Entity.User.User_Info;
import com.idle.shoppingmall.RequestDTO.User.UserAccountAddRequest;


import com.idle.shoppingmall.RequestDTO.User.UserAccountLoginRequest;
import com.idle.shoppingmall.RequestDTO.User.UserAccountUpdateRequest;
import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import com.idle.shoppingmall.ResponseDTO.UserAccount.UserAccountAddResponse;
import com.idle.shoppingmall.ResponseDTO.UserAccount.UserAccountDeleteResponse;
import com.idle.shoppingmall.ResponseDTO.UserAccount.UserAccountUpdateResponse;
import com.idle.shoppingmall.Service.User.UserAccountService;
import com.idle.shoppingmall.Service.User.UserInfoService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserAccountApiController {
    private final UserAccountService userAccountService;
    private final PasswordEncoder passwordEncoder;
    private final UserInfoService userInfoService;

    @PostMapping("/addUserAccount")
    public ResponseEntity<UserAccountAddResponse> addUserAccount(@RequestBody @Valid UserAccountAddRequest request){
        if (request.getUser_email() == null) {
            return ResponseEntity.ok().body(new UserAccountAddResponse(400, "XX", null));
        }
        Long id = userAccountService.addUserAccount
                (User_Account.builder()
                        .user_email(request.getUser_email())
                        .user_password(passwordEncoder.encode(request.getUser_password()))
                        .user_pnum(request.getUser_pnum())
                        .user_role(User_Account.UserRole.USER)
                        .last_login(LocalDateTime.now())
                .build()
        );

        User_Account account = userAccountService.getUserByEmail(request.getUser_email());

        userInfoService.addUser_Info(User_Info.builder()
                        .user_id(account.getUser_id())
                        .name(account.getUser_email())
                        .build());


        if(id==null){
            return ResponseEntity.ok().body(new UserAccountAddResponse(400,"실패",null));
        }

        return ResponseEntity.ok().body(new UserAccountAddResponse(200,"성공", request.getUser_email()));
    }

    // 사용자 계정 목록 조회
    @GetMapping("/api/userAccounts")
    public ResponseEntity<List<User_Account>> listUserAccounts() {
        List<User_Account> userAccounts = userAccountService.listAllUserAccounts();
        if (userAccounts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(userAccounts);
    }

    // 사용자 계정 업데이트
    @PostMapping("api/updateUserAccount")
    public ResponseEntity<UserAccountUpdateResponse> updateUserAccount(
                                                                       @RequestBody @Valid UserAccountUpdateRequest request,
                        HttpSession session) {

        User_Info user = (User_Info) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.ok(new UserAccountUpdateResponse(700, "로그인이 필요합니다.", null));
        }

        boolean id = userAccountService.updateUserAccount
                (User_Account.builder()
                        .user_id(user.getUser_id())
                        .user_email(request.getUser_email())
                        .user_password(passwordEncoder.encode(request.getUser_password()))
                        .user_pnum(request.getUser_pnum())

                        .build()
                );
        if(!id){
            return ResponseEntity.ok().body(new UserAccountUpdateResponse(400,"실패",null));
        }

        return ResponseEntity.ok().body(new UserAccountUpdateResponse(200,"성공",user.getUser_id()));
    }

    /*@GetMapping("/api/GET/deleteUserAccount")
    public ResponseEntity<UserAccountDeleteResponse> deleteUserAccount(@RequestBody @Valid userAccountrDeleteRequest request){
        UserAccountDeleteResponse
    }*/

    // 사용자 계정 삭제
    @DeleteMapping("/api/userAccounts/{userEmail}")
    public ResponseEntity<UserAccountDeleteResponse> deleteUserAccount(@PathVariable String userEmail) {
        if(userEmail == null || userEmail.isEmpty()) {
            // 이메일이 제공되지 않았을 경우의 처리
            return ResponseEntity.badRequest().body(new UserAccountDeleteResponse(400,"요청이 잘못되었습니다: 이메일을 제공해주세요.", null));
        }
        boolean isDeleted = userAccountService.deleteUserAccount(userEmail); // userEmail 파라미터를 사용
        if(isDeleted) {
            // 삭제 성공
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            // 해당 이메일을 가진 사용자를 찾을 수 없거나 삭제에 실패한 경우
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new UserAccountDeleteResponse(404, "해당 이메일을 가진 사용자를 찾을 수 없습니다.", null));
        }
    }



} // end class
