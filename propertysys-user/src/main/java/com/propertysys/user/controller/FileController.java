package com.propertysys.user.controller;

import com.propertysys.user.utils.Result;
import com.propertysys.user.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${file.storage.avatar-path}")
    private String avatarPath;

    @Value("${file.base-url.avatars}")
    private String baseUrl;

    @PostMapping("/upload")
    public Result<String> uploadAvatar(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.failure(ResultCodeEnum.FILE_IS_EMPTY);
        }

        try {
            // 生成唯一文件名
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            Path path = Paths.get(avatarPath, fileName);

            // 保存文件到指定路径
            Files.copy(file.getInputStream(), path);

            // 返回文件的URL
            String fileUrl = baseUrl + fileName;
            return Result.success(fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.failure(ResultCodeEnum.FILE_UPLOAD_FAILED);
        }
    }
}
