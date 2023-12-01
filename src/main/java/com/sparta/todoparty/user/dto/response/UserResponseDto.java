package com.sparta.todoparty.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private final String nickname;
    private final String imagePath;
    private final String intro;

    @Builder
    public UserResponseDto(final String nickname, final String imagePath, final String intro) {
        this.nickname = nickname;
        this.imagePath = imagePath;
        this.intro = intro;
    }
}