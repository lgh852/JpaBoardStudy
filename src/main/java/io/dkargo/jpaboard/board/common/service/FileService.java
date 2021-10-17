package io.dkargo.jpaboard.board.common.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String uploadFile(MultipartFile file);

    String changeFile(MultipartFile file, String newFileName);

    void deleteFile(String filePath);
}
