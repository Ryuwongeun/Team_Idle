package com.idle.shoppingmall.Config.Mail;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final RegisterMail registerMail;
    @PostMapping("/login/mailConfirm")
    public ResponseEntity<EmailResponseDTO> mailConfirm(@RequestBody @Valid EmailRequestDTO request) throws Exception {
        System.out.println("이메일 : " + request.email);
        String data = registerMail.sendEmail(request.email);
        System.out.println("인증코드 : " + data);
        if(data != null) {
            return ResponseEntity.ok().body(new EmailResponseDTO(200, "인증 메일을 전송했습니다.", data));
        }
        return ResponseEntity.ok().body(new EmailResponseDTO(400, "메일 전송에 실패했습니다.", null));
    }
}
