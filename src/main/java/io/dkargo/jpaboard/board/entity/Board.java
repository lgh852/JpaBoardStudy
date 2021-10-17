package io.dkargo.jpaboard.board.entity;

import io.dkargo.jpaboard.board.board.dto.request.ReqCreateBoardDto;
import io.dkargo.jpaboard.board.board.dto.request.ReqUpdateBoardDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Getter
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<BoardCategory> boardCategory;

    @NotBlank
    private String title;

    @Column(length = 1000)
    private String content;

    public Board(ReqCreateBoardDto dto, User user, List<Category> categoryList) {
        this.user = user;
        this.boardCategory = categoryList.stream().map(u -> new BoardCategory(this, u)).collect(Collectors.toList());
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.changeAt = LocalDateTime.now();
    }

    public void changeBoard(ReqUpdateBoardDto reqDto, List<Category> categoryList) {
        this.title = reqDto.getTitle();
        this.content = reqDto.getContent();
        this.boardCategory = categoryList.stream().map(u -> new BoardCategory(this, u)).collect(Collectors.toList());
    }

}
