package io.dkargo.jpaboard.board.category.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResUpdateCategoryDto {

    @ApiModelProperty( value = "카테고리 ID" )
    private Long categoryId;

    @ApiModelProperty( value = "카테고리 제목" )
    private String title;

}
