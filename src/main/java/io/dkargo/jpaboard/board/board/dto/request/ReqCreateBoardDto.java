package io.dkargo.jpaboard.board.board.dto.request;

import io.dkargo.jpaboard.board.entity.Category;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ReqCreateBoardDto {

    @NotNull
    @ApiModelProperty( value = "회원번호", required = true )
    private long userId;

    @NotNull
    @ApiModelProperty( value = "카테고리 ID", required = true )
    private List<Long> categoryList;

    @NotBlank
    @ApiModelProperty( value = "제목", required = true )
    private String title;

    @NotBlank
    @ApiModelProperty( value = "내용", required = true )
    private String content;
}
