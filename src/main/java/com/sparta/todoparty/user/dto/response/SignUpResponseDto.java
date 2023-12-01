package com.sparta.todoparty.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private final Long id;
    private final String username;
    private final String email;
    private final String nickname;

    @Builder
    public SignUpResponseDto(final Long id, final String username, final String email, final String nickname) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.nickname = nickname;
    }
}