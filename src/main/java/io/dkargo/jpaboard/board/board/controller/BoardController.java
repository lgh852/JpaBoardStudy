package io.dkargo.jpaboard.board.board.controller;

import io.dkargo.jpaboard.board.board.service.BoardService;
import io.dkargo.jpaboard.board.board.dto.request.ReqCreateBoardDto;
import io.dkargo.jpaboard.board.board.dto.request.ReqUpdateBoardDto;
import io.dkargo.jpaboard.board.board.dto.response.ResCreateBoardDto;
import io.dkargo.jpaboard.board.board.dto.response.ResGetBoardDetailDto;
import io.dkargo.jpaboard.board.board.dto.response.ResGetBoardListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResCreateBoardDto createBoard(@Validated @RequestBody ReqCreateBoardDto dto) {
        return boardService.createBoard(dto);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResGetBoardListDto getBoardList(@RequestParam("page") int page, @RequestParam("size") int size) {
        return boardService.getBoardList(page, size);
    }

    @GetMapping("/{boardId}")
    @ResponseStatus(HttpStatus.OK)
    public ResGetBoardDetailDto getBoardDetail(@PathVariable("boardId") long userId) {
        return boardService.getBoardDetail(userId);
    }

    @PatchMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Boolean updateBoard(@Validated @RequestBody ReqUpdateBoardDto dto) {
        return boardService.updateBoard(dto);
    }

}