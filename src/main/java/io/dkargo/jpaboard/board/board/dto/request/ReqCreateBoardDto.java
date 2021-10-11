package io.dkargo.jpaboard.board.board.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ReqCreateBoardDto {

    @NotNull
    @ApiModelProperty( value = "회원번호", required = true )
    private long userId;

    @NotNull
    @ApiModelProperty( value = "카테고리 ID", required = true )
    private long categoryId;

    @NotEmpty
    @ApiModelProperty( value = "제목", required = true )
    private String title;

    @NotEmpty
    @ApiModelProperty( value = "내용", required = true )
    private String content;
}
