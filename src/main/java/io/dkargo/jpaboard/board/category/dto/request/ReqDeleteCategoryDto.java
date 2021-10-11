package io.dkargo.jpaboard.board.category.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReqDeleteCategoryDto {

    @NotNull
    @ApiModelProperty( value = "카테고리 ID", required = true )
    private Long categoryId;

    @NotNull
    @ApiModelProperty( value = "유저 ID", required = true )
    private Long userId;

}
