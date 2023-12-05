package com.sparta.todoparty.card.dto.request;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CardRequestDto {

    private String title;
    private String content;
    private String attachment;
}
