package com.sparta.todoparty.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginResponseDto {
    private final Long id;
    private final String username;

    @Builder
    public LoginResponseDto(final Long id, final String username) {
        this.id = id;
        this.username = username;
    }
}
