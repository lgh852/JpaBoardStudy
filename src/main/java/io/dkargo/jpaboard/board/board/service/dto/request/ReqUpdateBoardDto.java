package io.dkargo.jpaboard.board.board.service.dto.request;

import lombok.Data;

@Data
public class ReqUpdateBoardDto {

    private long boardId;

    private String title;

    private String content;

}
