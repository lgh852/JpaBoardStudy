package io.dkargo.jpaboard.board.entity;

import io.dkargo.jpaboard.board.board.dto.request.ReqCreateBoardDto;
import io.dkargo.jpaboard.board.board.dto.request.ReqUpdateBoardDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @NotEmpty
    private String title;

    @Column(length = 1000)
    private String content;

    public Board(ReqCreateBoardDto dto, User user, Category category) {
        this.user = user;
        this.category = category;
        this.title = dto.getTitle();
        this.content = dto.getContent();
    }

    public void changeBoard(ReqUpdateBoardDto reqDto, Optional<Category> category) {

        if( !this.title.equals(reqDto.getTitle()) ){
            this.title = title;
        }

        if( !this.content.equals(reqDto.getContent()) ){
            this.content = content;
        }

        if( category.isPresent() ){
            this.category = category.get();
        }

        this.setChangeAt(LocalDateTime.now());
    }

}
