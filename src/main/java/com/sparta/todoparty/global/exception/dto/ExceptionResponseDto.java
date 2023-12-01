package com.sparta.todoparty.global.exception.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ExceptionResponseDto {

    private final int statusCode;
    private final String message;

    @Builder
    public ExceptionResponseDto(final int statusCode, final String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}