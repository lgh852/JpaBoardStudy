package io.dkargo.jpaboard.board.user.service.impl;

import io.dkargo.jpaboard.board.entity.PageRequest;
import io.dkargo.jpaboard.board.entity.User;
import io.dkargo.jpaboard.board.error.DkargoException;
import io.dkargo.jpaboard.board.error.ErrorCode;
import io.dkargo.jpaboard.board.user.dto.request.ReqCreateUserDto;
import io.dkargo.jpaboard.board.user.dto.request.ReqUpdateUserDto;
import io.dkargo.jpaboard.board.user.dto.response.ResCreateUserDto;
import io.dkargo.jpaboard.board.user.dto.response.ResGetUserDetailDto;
import io.dkargo.jpaboard.board.user.dto.response.ResGetUserListDto;
import io.dkargo.jpaboard.board.user.repository.UserRepository;
import io.dkargo.jpaboard.board.user.service.UserServce;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserServce {

    private final UserRepository userRepository;

    public ResCreateUserDto createUser(ReqCreateUserDto dto) {

        if (checkEmailDuplicate(dto.getEmail())) {
            throw new DkargoException(ErrorCode.EMAIL_DUPLICATED);
        }

        User user = new User(dto);
        userRepository.save(user);

        return new ResCreateUserDto(user.getId());
    }

    public ResGetUserListDto getUserList(int page, int size) {
        PageRequest pr = new PageRequest(page, size, Sort.Direction.DESC);
        List<User> userList = userRepository.findAll(pr.of()).getContent();

        long count = userRepository.count();
        int totalPage = (int) ((count + size - 1) / size);
        return new ResGetUserListDto(userList, page, size, totalPage);
    }

    public ResGetUserDetailDto getUserDetail(long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new DkargoException(ErrorCode.USER_NOT_FOUND));

        return new ResGetUserDetailDto(user);
    }

    public boolean updateUser(ReqUpdateUserDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new DkargoException(ErrorCode.USER_NOT_FOUND));

        user.changeNickname(dto.getNickname());

        return true;
    }

    private boolean checkEmailDuplicate(String email) {
        return userRepository.existsByEmail(email);
    }
}