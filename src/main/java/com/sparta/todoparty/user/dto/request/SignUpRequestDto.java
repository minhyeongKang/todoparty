package com.sparta.todoparty.user.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SignUpRequestDto {

    private final String username;
    private final String password;
    private final String email;
    private final String nickname;

    @Builder
    public SignUpRequestDto(final String username, final String password, final String email,
                            final String nickname) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
    }
}