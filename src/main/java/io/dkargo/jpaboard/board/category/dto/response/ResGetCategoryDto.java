package io.dkargo.jpaboard.board.category.dto.response;


import io.dkargo.jpaboard.board.entity.Category;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ResGetCategoryDto {

    @ApiModelProperty(value = "카테고리 ID")
    private Long categoryId;

    @ApiModelProperty(value = "카테고리 제목")
    private String title;

    @ApiModelProperty(value = "등록일")
    private LocalDateTime createAt;

    @ApiModelProperty(value = "최종 수정일")
    private LocalDateTime changeAt;

    public ResGetCategoryDto(Category category) {
        this.categoryId = category.getId();
        this.title = category.getTitle();
        this.createAt = category.getCreateAt();
        this.changeAt = category.getChangeAt();
    }
}