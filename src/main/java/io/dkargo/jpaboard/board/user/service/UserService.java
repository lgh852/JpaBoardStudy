package io.dkargo.jpaboard.board.user.service;

import io.dkargo.jpaboard.board.user.dto.request.ReqCreateUserDto;
import io.dkargo.jpaboard.board.user.dto.request.ReqUpdateUserDto;
import io.dkargo.jpaboard.board.user.dto.response.ResCreateUserDto;
import io.dkargo.jpaboard.board.user.dto.response.ResGetUserDetailDto;
import io.dkargo.jpaboard.board.user.dto.response.ResGetUserListDto;
import io.dkargo.jpaboard.board.user.dto.response.ResUpdateUserDto;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    public ResCreateUserDto createUser(ReqCreateUserDto dto, MultipartFile profile);

    public ResGetUserListDto getUserList(int page, int size);

    public ResGetUserDetailDto getUserDetail(long userId);

    public ResUpdateUserDto updateUser(ReqUpdateUserDto dto, MultipartFile profile);

    Boolean deleteUser(Long userId);
}
