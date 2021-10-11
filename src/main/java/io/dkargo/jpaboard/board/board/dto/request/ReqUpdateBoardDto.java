package io.dkargo.jpaboard.board.board.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ReqUpdateBoardDto {

    @NotNull
    @ApiModelProperty( value = "게시판 ID", required = true )
    private long boardId;

    @ApiModelProperty( value = "카테고리 ID" )
    private long categoryId;

    @ApiModelProperty( value = "카테고리 ID" )
    private String title;

    @ApiModelProperty( value = "내용" )
    private String content;

}
