package io.dkargo.jpaboard.board.user.controller;

import io.dkargo.jpaboard.board.user.dto.request.ReqCreateUserDto;
import io.dkargo.jpaboard.board.user.dto.request.ReqUpdateUserDto;
import io.dkargo.jpaboard.board.user.dto.response.ResCreateUserDto;
import io.dkargo.jpaboard.board.user.dto.response.ResGetUserDetailDto;
import io.dkargo.jpaboard.board.user.dto.response.ResGetUserListDto;
import io.dkargo.jpaboard.board.user.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserServiceImpl userService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ResCreateUserDto> createUser(@Validated @RequestBody ReqCreateUserDto dto) {
        // TODO : controller에서 사용한 dto는 service용으로 따로 생성해서 주고 받도록 하자!
        ResCreateUserDto result = userService.createUser(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResGetUserListDto getUserList(@RequestParam("page") int page, @RequestParam("size") int size) {
        return userService.getUserList(page, size);
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResGetUserDetailDto getUserDetail(@PathVariable("userId") long userId) {
        return userService.getUserDetail(userId);
    }

    @PatchMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Boolean updateUser(@Validated @RequestBody ReqUpdateUserDto dto) {
        return userService.updateUser(dto);
    }
}
