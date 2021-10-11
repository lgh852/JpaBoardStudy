package io.dkargo.jpaboard.board.board.service;

import io.dkargo.jpaboard.board.board.dto.request.ReqCreateBoardDto;
import io.dkargo.jpaboard.board.board.dto.request.ReqUpdateBoardDto;
import io.dkargo.jpaboard.board.board.dto.response.ResCreateBoardDto;
import io.dkargo.jpaboard.board.board.dto.response.ResGetBoardDto;
import io.dkargo.jpaboard.board.board.dto.response.ResGetBoardListDto;

public interface BoardService {
    public ResCreateBoardDto createBoard(ReqCreateBoardDto dto);

    public ResGetBoardListDto getBoardList(int page, int size);

    public ResGetBoardDto getBoardDetail(long userId);

    public Boolean updateBoard(ReqUpdateBoardDto dto);
}
