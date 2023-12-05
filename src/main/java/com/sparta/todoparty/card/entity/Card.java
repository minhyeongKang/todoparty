package com.sparta.todoparty.card.entity;

import com.sparta.todoparty.card.dto.request.CardRequestDto;
import com.sparta.todoparty.comment.entity.Comment;
import com.sparta.todoparty.global.entity.BaseEntity;
import com.sparta.todoparty.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "TB_BOARD")
public class Card extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Builder
    public Card(final String title, final String content, final User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    @OneToMany(mappedBy = "card")
    private final List<Comment> comments = new ArrayList<>();

    public void update(CardRequestDto cardRequestDto) {
        this.title = cardRequestDto.getTitle();
        this.content = cardRequestDto.getContent();
    }
}
