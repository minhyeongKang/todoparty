package com.sparta.todoparty.comment.dto.response;

import com.sparta.todoparty.comment.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentWithUserResponseDto {

    private final Long id;
    private final String nickname;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CommentWithUserResponseDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.createdAt = comment.getCreateAt();
        this.modifiedAt = comment.getModifiedAt();
        this.nickname = comment.getUser() == null ? "탈퇴한 사용자" : comment.getUser().getNickname();
    }
}
