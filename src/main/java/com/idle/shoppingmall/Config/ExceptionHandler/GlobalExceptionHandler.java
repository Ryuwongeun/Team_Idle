package com.idle.shoppingmall.Config.ExceptionHandler;

import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CommonResponse> processValidationError(MethodArgumentNotValidException ex) {
        return ResponseEntity.ok().body(new CommonResponse(400, "잘못된 요청입니다."));
    }

}
