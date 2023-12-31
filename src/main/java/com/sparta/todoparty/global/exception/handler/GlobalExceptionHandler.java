package com.sparta.todoparty.global.exception.handler;

import com.sparta.todoparty.global.exception.dto.ExceptionResponseDto;
import com.sparta.todoparty.global.exception.type.CustomException;
import com.sparta.todoparty.user.exception.AlreadyExistEmailException;
import com.sparta.todoparty.user.exception.AlreadyExistNicknameException;
import com.sparta.todoparty.user.exception.AlreadyExistUsernameException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyExistEmailException.class)
    public ResponseEntity<ExceptionResponseDto> handleAlreadyExistEmailException() {
        return ResponseEntity
                .status(CustomException.ALREADY_EXIST_EMAIL.getStatusCode())
                .body(CustomException.ALREADY_EXIST_EMAIL.toDto());
    }

    @ExceptionHandler(AlreadyExistNicknameException.class)
    public ResponseEntity<ExceptionResponseDto> handleAlreadyExistNicknameException() {
        return ResponseEntity
                .status(CustomException.ALREADY_EXIST_NICKNAME.getStatusCode())
                .body(CustomException.ALREADY_EXIST_NICKNAME.toDto());
    }

    @ExceptionHandler(AlreadyExistUsernameException.class)
    public ResponseEntity<ExceptionResponseDto> handleAlreadyExistUsernameException() {
        return ResponseEntity
                .status(CustomException.ALREADY_EXIST_USERNAME.getStatusCode())
                .body(CustomException.ALREADY_EXIST_USERNAME.toDto());
    }
}