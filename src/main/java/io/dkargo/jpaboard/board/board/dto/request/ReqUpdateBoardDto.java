package io.dkargo.jpaboard.board.board.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ReqUpdateBoardDto {

    @NotEmpty
    private long boardId;

    private String title;

    private String content;

}
