package io.dkargo.jpaboard.board.board.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class ReqDeleteBoardDto {

    @NotNull
    @ApiModelProperty(value = "등록 회원 아이디")
    private Long userId;

    @NotNull
    @ApiModelProperty(value = "삭제할 게시판 ID")
    private Long boardId;

}
