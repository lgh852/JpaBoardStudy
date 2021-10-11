package io.dkargo.jpaboard.board.board.dto.response;

import io.dkargo.jpaboard.board.entity.Board;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ResGetBoardDto {

    @ApiModelProperty( value = "게시판 제목" )
    private String title;

    @ApiModelProperty( value = "게시판 내용" )
    private String content;

    @ApiModelProperty( value = "카테고리 제목" )
    private String categoryTitle;

    @ApiModelProperty( value = "작성자" )
    private String writer;

    @ApiModelProperty( value = "등록일" )
    private LocalDateTime createdAt;

    @ApiModelProperty( value = "변경일" )
    private LocalDateTime updatedAt;

    public ResGetBoardDto(Board board) {
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getUser().getNickname();
        this.categoryTitle = board.getCategory().getTitle();
        this.createdAt = board.getCreateAt();
        this.updatedAt = board.getChangeAt();
    }
}
