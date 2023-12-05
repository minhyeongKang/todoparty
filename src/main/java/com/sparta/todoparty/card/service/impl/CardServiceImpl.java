package com.sparta.todoparty.card.service.impl;

import com.sparta.todoparty.card.dto.request.CardRequestDto;
import com.sparta.todoparty.card.dto.response.CardResponseDto;
import com.sparta.todoparty.card.dto.response.CardWithCommentResponseDto;
import com.sparta.todoparty.card.entity.Card;
import com.sparta.todoparty.card.exception.NotFoundBoardException;
import com.sparta.todoparty.card.exception.NotMatchUserException;
import com.sparta.todoparty.card.repository.CardRepository;
import com.sparta.todoparty.card.service.CardService;
import com.sparta.todoparty.comment.dto.response.CommentWithUserResponseDto;
import com.sparta.todoparty.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public CardResponseDto createCard(CardRequestDto cardRequestDto, User user) {
        Card card = Card.builder()
                .title(cardRequestDto.getTitle())
                .content(cardRequestDto.getContent())
                .user(user)
                .build();

        card = cardRepository.save(card);

        return new CardResponseDto(card);
    }

    @Transactional
    @Override
    public CardResponseDto updateCard(Long cardId, CardRequestDto cardRequestDto, User user) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(NotFoundBoardException::new);
        if (!user.getId().equals(card.getUser().getId())) {
            throw new NotMatchUserException();
        }
        card.update(cardRequestDto);

        return new CardResponseDto(card);
    }

    @Override
    public CardResponseDto deleteCard(Long cardId, User user) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(NotFoundBoardException::new);
        if (!user.getId().equals(card.getUser().getId())) {
            throw new NotMatchUserException();
        }
        cardRepository.delete(card);

        return new CardResponseDto(card);
    }

    @Transactional(readOnly = true)
    @Override
    public CardWithCommentResponseDto getCard(Long cardId) {
        Card card = cardRepository.findById(cardId).orElseThrow(NotFoundBoardException::new);

        List<CommentWithUserResponseDto> comments = card.getComments()
                .stream()
                .map(comment -> {
                    return new CommentWithUserResponseDto(comment);
                })
                .toList();

        return CardWithCommentResponseDto.builder()
                .id(card.getId())
                .title(card.getTitle())
                .nickname(card.getUser().getNickname())
                .content(card.getContent())
                .comments(comments)
                .createdAt(card.getCreateAt())
                .modifiedAt(card.getModifiedAt())
                .build();
    }
}
