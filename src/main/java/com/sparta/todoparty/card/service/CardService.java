package com.sparta.todoparty.card.service;

import com.sparta.todoparty.card.dto.request.CardRequestDto;
import com.sparta.todoparty.card.dto.response.CardResponseDto;
import com.sparta.todoparty.card.dto.response.CardWithCommentResponseDto;
import com.sparta.todoparty.user.entity.User;

import java.util.List;

public interface CardService {

    CardResponseDto createCard(CardRequestDto cardRequestDto, User user);
    CardResponseDto updateCard(Long cardId, CardRequestDto cardRequestDto, User user);
    CardResponseDto deleteCard(Long cardId, User user);
    CardWithCommentResponseDto getCard(Long cardId);
}
