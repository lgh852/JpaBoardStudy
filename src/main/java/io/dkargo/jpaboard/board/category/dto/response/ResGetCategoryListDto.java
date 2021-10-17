package io.dkargo.jpaboard.board.category.dto.response;

import io.dkargo.jpaboard.board.entity.Category;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ResGetCategoryListDto {

    @ApiModelProperty( value = "현재 페이지 번호" )
    private int page;

    @ApiModelProperty( value = "한페이지 SIZE" )
    private int size;

    @ApiModelProperty( value = "전체 페이지 수" )
    private int totalPage;

    private List<GetCategoryDto> list = new ArrayList<>();

    public ResGetCategoryListDto(List<Category> list, int page, int size, int totalPage) {
        this.list = list.stream().map(u -> new GetCategoryDto(u)).collect(Collectors.toList());
        this.page = page;
        this.size = size;
        this.totalPage = totalPage;
    }

    @Data
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public class GetCategoryDto {

        @ApiModelProperty(value = "카테고리 ID")
        private Long categoryId;

        @ApiModelProperty(value = "카테고리 제목")
        private String title;

        @ApiModelProperty(value = "등록일")
        private LocalDateTime createAt;

        @ApiModelProperty(value = "최종 수정일")
        private LocalDateTime changeAt;

        public GetCategoryDto(Category category) {
            this.categoryId = category.getId();
            this.title = category.getTitle();
            this.createAt = category.getCreateAt();
            this.changeAt = category.getChangeAt();
        }
    }
}
