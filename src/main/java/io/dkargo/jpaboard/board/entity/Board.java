package io.dkargo.jpaboard.board.entity;

import io.dkargo.jpaboard.board.board.dto.request.ReqCreateBoardDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotEmpty
    private String title;

    @Column(length = 1000)
    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Board(ReqCreateBoardDto dto, User user) {
        this.user = user;
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = createdAt;
    }

    public void changeTitle(String title) {
        this.title = title;
        this.updatedAt = LocalDateTime.now();
    }

    public void changeContent(String content) {
        this.content = content;
        this.updatedAt = LocalDateTime.now();
    }

}
