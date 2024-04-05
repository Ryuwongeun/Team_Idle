package com.idle.shoppingmall.Config.Mail;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final RegisterMail registerMail;
    @PostMapping("/login/mailConfirm")
    public String mailConfirm(@RequestBody EmailRequestDTO request) throws Exception {
        System.out.println("이메일 : " + request.email);
        String code = registerMail.sendEmail(request.email);
        System.out.println("인증코드 : " + code);
        return code;
    }
}
