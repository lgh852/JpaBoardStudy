package io.dkargo.jpaboard.board.board.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ReqUpdateBoardDto {

    @NotNull
    @ApiModelProperty( value = "게시판 ID", required = true )
    private long boardId;

    @NotNull
    @ApiModelProperty( value = "사용자 ID", required = true )
    private long userId;

    @ApiModelProperty( value = "카테고리 목록" )
    private List<Long> categoryList;

    @ApiModelProperty( value = "게시판 제목" )
    private String title;

    @ApiModelProperty( value = "내용" )
    private String content;

}
