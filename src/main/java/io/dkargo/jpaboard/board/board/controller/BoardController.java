package io.dkargo.jpaboard.board.board.controller;

import io.dkargo.jpaboard.board.board.dto.request.ReqDeleteBoardDto;
import io.dkargo.jpaboard.board.board.service.BoardService;
import io.dkargo.jpaboard.board.board.dto.request.ReqCreateBoardDto;
import io.dkargo.jpaboard.board.board.dto.request.ReqUpdateBoardDto;
import io.dkargo.jpaboard.board.board.dto.response.ResCreateBoardDto;
import io.dkargo.jpaboard.board.board.dto.response.ResGetBoardDto;
import io.dkargo.jpaboard.board.board.dto.response.ResGetBoardListDto;
import io.dkargo.jpaboard.board.category.dto.response.ResCreateCategoryDto;
import io.dkargo.jpaboard.board.category.dto.response.ResGetCategoryDto;
import io.dkargo.jpaboard.board.category.dto.response.ResGetCategoryListDto;
import io.dkargo.jpaboard.board.category.dto.response.ResUpdateCategoryDto;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @ApiOperation(
            value = "게시판 등록",
            notes = "게시판를 등록한다."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "생성된 게시판 ID", response = ResCreateBoardDto.class)
    })
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResCreateBoardDto createBoard(@Validated @RequestBody ReqCreateBoardDto dto) {
        return boardService.createBoard(dto);
    }

    @ApiOperation(
            value = "게시판 목록 조회",
            notes = "게시판 목록을 조회한다."
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "페이지 번호", required = false, defaultValue = "1", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "페이지 사이즈", required = false, defaultValue = "10", dataType = "string", paramType = "query"),
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "게시판 목록", response = ResGetBoardListDto.class)
    })
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResGetBoardListDto getBoardList(@RequestParam("page") int page, @RequestParam("size") int size) {
        return boardService.getBoardList(page, size);
    }

    @ApiOperation(
            value = "게시판 상세 조회",
            notes = "게시판 상세 정보를 조회한다."
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "boardId", value = "게시판 ID", required = true, dataType = "long", paramType = "path")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "게시판 상세 정보", response = ResGetCategoryDto.class)
    })
    @GetMapping("/{boardId}")
    @ResponseStatus(HttpStatus.OK)
    public ResGetBoardDto getBoardDetail(@PathVariable("boardId") long userId) {
        return boardService.getBoardDetail(userId);
    }

    @ApiOperation(
            value = "게시판 내용 변경",
            notes = "게시판 내용을 변경한다."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "변경시 true", response = Boolean.class)
    })
    @PatchMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Boolean updateBoard(@Validated @RequestBody ReqUpdateBoardDto dto) {
        return boardService.updateBoard(dto);
    }

    @ApiOperation(
            value = "게시판 삭제",
            notes = "게시판을 삭제한다."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "삭제 true", response = Boolean.class)
    })
    @DeleteMapping("/")
    public Boolean deleteBoard(@Validated @RequestBody ReqDeleteBoardDto reqDeleteBoardDto){
        return boardService.deleteBoard(reqDeleteBoardDto);
    }

}