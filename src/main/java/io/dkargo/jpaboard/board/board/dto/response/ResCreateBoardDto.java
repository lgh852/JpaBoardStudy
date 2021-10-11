package io.dkargo.jpaboard.board.board.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResCreateBoardDto {

    @ApiModelProperty( value = "등록한 게시판 ID" )
    private long boardId;
}
