package com.sparta.todoparty.card.dto.response;

import com.sparta.todoparty.comment.dto.response.CommentWithUserResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class CardWithUserResponseDto {

    private Long id;
    private String title;
    private String content;
    private String nickname;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private List<CommentWithUserResponseDto> comments;
}
