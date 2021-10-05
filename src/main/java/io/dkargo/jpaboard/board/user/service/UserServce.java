package io.dkargo.jpaboard.board.user.service;

import io.dkargo.jpaboard.board.user.dto.request.ReqCreateUserDto;
import io.dkargo.jpaboard.board.user.dto.request.ReqUpdateUserDto;
import io.dkargo.jpaboard.board.user.dto.response.ResCreateUserDto;
import io.dkargo.jpaboard.board.user.dto.response.ResGetUserDetailDto;
import io.dkargo.jpaboard.board.user.dto.response.ResGetUserListDto;

public interface UserServce {

    public ResCreateUserDto createUser(ReqCreateUserDto dto);

    public ResGetUserListDto getUserList(int page, int size);

    public ResGetUserDetailDto getUserDetail(long userId);

    public boolean updateUser(ReqUpdateUserDto dto);

}
