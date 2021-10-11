package io.dkargo.jpaboard.board.user.controller;

import io.dkargo.jpaboard.board.board.dto.response.ResCreateBoardDto;
import io.dkargo.jpaboard.board.board.dto.response.ResGetBoardListDto;
import io.dkargo.jpaboard.board.category.dto.response.ResGetCategoryDto;
import io.dkargo.jpaboard.board.user.dto.request.ReqCreateUserDto;
import io.dkargo.jpaboard.board.user.dto.request.ReqUpdateUserDto;
import io.dkargo.jpaboard.board.user.dto.response.ResCreateUserDto;
import io.dkargo.jpaboard.board.user.dto.response.ResGetUserDetailDto;
import io.dkargo.jpaboard.board.user.dto.response.ResGetUserListDto;
import io.dkargo.jpaboard.board.user.service.UserServce;
import io.dkargo.jpaboard.board.user.service.impl.UserServiceImpl;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserServce userService;
    @ApiOperation(
            value = "사용자 등록",
            notes = "사용자를 등록한다."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "생성된 사용자 ID", response = ResCreateUserDto.class)
    })
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResCreateUserDto createUser(@Validated @RequestBody ReqCreateUserDto dto) {
        return userService.createUser(dto);
    }

    @ApiOperation(
            value = "사용자 목록 조회",
            notes = "사용자 목록을 조회한다."
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "페이지 번호", required = false, defaultValue = "1", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "페이지 사이즈", required = false, defaultValue = "10", dataType = "string", paramType = "query"),
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "사용자 목록", response = ResGetUserListDto.class)
    })
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResGetUserListDto getUserList(@RequestParam("page") int page, @RequestParam("size") int size) {
        return userService.getUserList(page, size);
    }

    @ApiOperation(
            value = "사용자 상세 조회",
            notes = "사용자 상세 정보를 조회한다."
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "사용자 ID", required = true, dataType = "long", paramType = "path")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "사용자 상세 정보", response = ResGetUserDetailDto.class)
    })
    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResGetUserDetailDto getUserDetail(@PathVariable("userId") long userId) {
        return userService.getUserDetail(userId);
    }

    @ApiOperation(
            value = "사용자 내용 변경",
            notes = "사용자 내용을 변경한다."
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "변경시 true", response = Boolean.class)
    })
    @PatchMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Boolean updateUser(@Validated @RequestBody ReqUpdateUserDto dto) {
        return userService.updateUser(dto);
    }
}
