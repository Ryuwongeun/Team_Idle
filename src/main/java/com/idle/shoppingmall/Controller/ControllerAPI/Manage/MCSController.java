package com.idle.shoppingmall.Controller.ControllerAPI.Manage;

import com.idle.shoppingmall.Config.Mail.RegisterMail;
import com.idle.shoppingmall.Entity.User.UserInfo;
import com.idle.shoppingmall.RequestDTO.CustomerService.CSAnswerRequest;
import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import com.idle.shoppingmall.Service.CustomerService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequiredArgsConstructor
public class MCSController {
    private final CustomerService customerService;
    private final RegisterMail registerMail;

    @PostMapping("/manage/POST/cs")
    public ResponseEntity<CommonResponse> getCSList(@RequestBody CSAnswerRequest request, HttpSession session) throws MessagingException, UnsupportedEncodingException {
        UserInfo user = (UserInfo) session.getAttribute("user");
        if(user == null) return ResponseEntity.ok().body(new CommonResponse(666, "로그인이 필요합니다."));
        CommonResponse response = customerService.answerCS(request, user.getUser_id()) == null
                ? new CommonResponse(400, "답변 등록에 실패했습니다.")
                : new CommonResponse(200, "답변 등록에 성공했습니다.");
        String email = customerService.sendMail(request.getCs_id());
        registerMail.sendEmail(email,request.getContent());
        return ResponseEntity.ok().body(response);
    }
}
