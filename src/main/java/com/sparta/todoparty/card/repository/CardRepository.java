package com.sparta.todoparty.card.repository;

import com.sparta.todoparty.card.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findAllByOrderByCreateAtDesc();

    List<Card> findByUserId(Long userId);
}
