package io.dkargo.jpaboard.board.board.dto.response;

import io.dkargo.jpaboard.board.entity.Board;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class ResGetBoardDto {

    @ApiModelProperty( value = "게시판 번호" )
    private Long id;

    @ApiModelProperty( value = "게시판 제목" )
    private String title;

    @ApiModelProperty( value = "게시판 내용" )
    private String content;

    @ApiModelProperty( value = "카테고리 목록")
    private List<Category> categoryList;

    @ApiModelProperty( value = "작성자" )
    private String writer;

    @ApiModelProperty( value = "등록일" )
    private LocalDateTime createdAt;

    @ApiModelProperty( value = "변경일" )
    private LocalDateTime updatedAt;

    @Data
    @AllArgsConstructor
    private class Category{

        private Long id;
        private String title;

        public Category(io.dkargo.jpaboard.board.entity.Category category){
            this.id = category.getId();
            this.title = category.getTitle();
        }

    }
    public ResGetBoardDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getUser().getNickname();
        this.categoryList = board.getBoardCategory().stream().map(u -> new Category(u.getCategory())).collect(Collectors.toList());
        this.createdAt = board.getCreateAt();
        this.updatedAt = board.getChangeAt();
    }
}
