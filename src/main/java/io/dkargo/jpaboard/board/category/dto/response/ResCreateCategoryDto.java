package io.dkargo.jpaboard.board.category.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResCreateCategoryDto {

    @ApiModelProperty( value="카테고리 번호" )
    private long categoryId;
}
