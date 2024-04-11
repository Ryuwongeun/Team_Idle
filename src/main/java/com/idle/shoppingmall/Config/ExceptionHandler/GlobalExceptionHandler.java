package com.idle.shoppingmall.Config.ExceptionHandler;

import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CommonResponse> processValidationError(MethodArgumentNotValidException ex) {
        return ResponseEntity.ok().body(new CommonResponse(400, "잘못된 요청입니다."));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CommonResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        // 예외 메시지를 포함하여 사용자 정의 응답 반환
        CommonResponse response = new CommonResponse(500, "인자가 잘못됐습니다.");
        log.warn("인자가 잘못됐습니다.");
        return  ResponseEntity.ok().body(response);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CommonResponse> handleIllegalArgumentException(NullPointerException ex) {
        // 예외 메시지를 포함하여 사용자 정의 응답 반환
        CommonResponse response = new CommonResponse(500, "데이터가 없습니다.");
        log.warn("데이터가 없습니다. Null 이에요");
        return  ResponseEntity.ok().body(response);
    }
}
