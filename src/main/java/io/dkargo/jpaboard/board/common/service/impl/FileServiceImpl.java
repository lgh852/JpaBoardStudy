package io.dkargo.jpaboard.board.common.service.impl;

import io.dkargo.jpaboard.board.common.service.FileService;
import io.dkargo.jpaboard.board.error.DkargoException;
import io.dkargo.jpaboard.board.error.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Slf4j
@Service
public class FileServiceImpl implements FileService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public String uploadFile(MultipartFile file) {

        /**
         * 1. 파일 유효성 검사
         */
        if (file.isEmpty()) {
            log.error("###File is Empty : {}", file.getOriginalFilename());
            throw new DkargoException(ErrorCode.FILE_NOT_FOUND);
        }

        try {
            Path uploadTargetDir = Paths.get(uploadDir).toAbsolutePath().normalize();

            /**
             * 2. 폴더생성 체크
             */
            File makeFolder = new File(uploadTargetDir.toString());
            if (!makeFolder.exists()) {
                makeFolder.mkdir();
            }

            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            String ext = fileName.substring(fileName.lastIndexOf("."));

            /**
             * 3. 유니크한 파일명 생성
             */
            UUID uuid = UUID.randomUUID();
            String newFileName = uuid.toString() + ext;

            Path targetLocation = uploadTargetDir.resolve(newFileName);

            /**
             * 4. 파일 생성
             */
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return uploadDir + File.separator + newFileName;

        } catch (Exception e) {
            log.error("###File Save Error : {}", file.getOriginalFilename());
            throw new DkargoException(ErrorCode.FILE_UPLOAD_FAILED);
        }
    }

    @Override
    public String changeFile(MultipartFile file, String orgFileName) {

        /**
         * 1. 파일 유효성 검사
         */
        if (file.isEmpty()) {
            log.error("###File is Empty : {}", file.getOriginalFilename());
            return null;
        }

        try {
            Path uploadTargetDir = Paths.get(uploadDir).toAbsolutePath().normalize();

            /**
             * 2. 폴더생성 체크
             */
            File makeFolder = new File(uploadTargetDir.toString());
            if (!makeFolder.exists()) {
                makeFolder.mkdir();
            }

            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            String ext = fileName.substring(fileName.lastIndexOf("."));

            Path targetLocation = uploadTargetDir.resolve(orgFileName);


            /**
             * 4. 파일 생성
             */
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return uploadDir + File.separator + orgFileName;

        } catch (Exception e) {
            log.error("###File Save Error : {}", file.getOriginalFilename());
            log.error(e.getMessage());
            throw new DkargoException(ErrorCode.FILE_UPLOAD_FAILED);
        }
    }

    public void deleteFile(String filePath) {

        File deleteFile = new File(filePath);

        // 파일이 존재하는지 체크 존재할경우 true, 존재하지않을경우 false
        if (deleteFile.exists()) {

            // 파일을 삭제합니다.
            deleteFile.delete();
        }
    }
}
