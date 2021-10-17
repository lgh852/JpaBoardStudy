package io.dkargo.jpaboard.board.user.service.impl;

import io.dkargo.jpaboard.board.common.service.FileService;
import io.dkargo.jpaboard.board.entity.PageRequest;
import io.dkargo.jpaboard.board.entity.User;
import io.dkargo.jpaboard.board.error.DkargoException;
import io.dkargo.jpaboard.board.error.ErrorCode;
import io.dkargo.jpaboard.board.user.dto.request.ReqCreateUserDto;
import io.dkargo.jpaboard.board.user.dto.request.ReqUpdateUserDto;
import io.dkargo.jpaboard.board.user.dto.response.ResCreateUserDto;
import io.dkargo.jpaboard.board.user.dto.response.ResGetUserDetailDto;
import io.dkargo.jpaboard.board.user.dto.response.ResGetUserListDto;
import io.dkargo.jpaboard.board.user.dto.response.ResUpdateUserDto;
import io.dkargo.jpaboard.board.user.repository.UserRepository;
import io.dkargo.jpaboard.board.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final FileService fileService;

    public ResCreateUserDto createUser(ReqCreateUserDto dto, MultipartFile profile) {

        if (checkEmailDuplicate(dto.getEmail())) {
            throw new DkargoException(ErrorCode.EMAIL_DUPLICATED);
        }
        String filePath = fileService.uploadFile(profile);

        User user = new User(dto, filePath);
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

    public ResUpdateUserDto updateUser(ReqUpdateUserDto dto, MultipartFile profile) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new DkargoException(ErrorCode.USER_NOT_FOUND));
        String newProfilePath = changeProfile(user.getProfilePath(), profile);
        user.changeUser(dto.getNickname(), newProfilePath);
        return new ResUpdateUserDto(user);
    }

    @Override
    public Boolean deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new DkargoException(ErrorCode.USER_NOT_FOUND));
        userRepository.delete(user);

        return true;
    }

    private boolean checkEmailDuplicate(String email) {
        return userRepository.existsByEmail(email);
    }

    private String changeProfile(String orgProFilePath, MultipartFile profile) {
        if (profile != null && !profile.isEmpty()) {
            fileService.deleteFile(orgProFilePath);
            return fileService.uploadFile(profile);
        } else {
            return null;
        }
    }
}