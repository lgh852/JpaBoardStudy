package io.dkargo.jpaboard.board.board.dto.response;

import io.dkargo.jpaboard.board.entity.Board;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class ResGetBoardListDto {

    @ApiModelProperty(value = "현재 페이지 번호")
    private int page;

    @ApiModelProperty(value = "한페이지 SIZE")
    private int size;

    @ApiModelProperty(value = "전체 페이지 수")
    private int totalPage;

    private List<GetBoard> list = new ArrayList<>();

    public ResGetBoardListDto(List<Board> list, int page, int size, int totalPage) {
        this.list = list.stream().map(u -> new GetBoard(u)).collect(Collectors.toList());
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
    }

    @Data
    private static class Category {

        private Long id;
        private String title;

        public Category(io.dkargo.jpaboard.board.entity.Category category) {
            this.id = category.getId();
            this.title = category.getTitle();
        }
    }
    @Data
    public static class GetBoard {

        @ApiModelProperty(value = "게시판 번호")
        private Long id;

        @ApiModelProperty(value = "제목")
        private String title;

        @ApiModelProperty(value = "내용")
        private String content;

        @ApiModelProperty(value = "작성자")
        private String writer;

        @ApiModelProperty(value = "카테고리 제목")
        private List<Category> categoryList;

        @ApiModelProperty(value = "등록일")
        private LocalDateTime createdAt;

        @ApiModelProperty(value = "수정일")
        private LocalDateTime updatedAt;


        public GetBoard(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.writer = board.getUser().getNickname();
            this.categoryList = board.getBoardCategory().stream().map(u -> new ResGetBoardListDto.Category(u.getCategory())).collect(Collectors.toList());
            this.createdAt = board.getCreateAt();
            this.updatedAt = board.getChangeAt();
        }
    }
}
