package com.propertysys.property.controller;

import com.propertysys.property.utils.Result;
import com.propertysys.property.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${file.storage.media-path}")
    private String fileStoragePath;

    @Value("${file.base-url.media}")
    private String fileBaseUrl;

    @PostMapping("/upload")
    public Result<String> uploadMedia(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.failure(ResultCodeEnum.FAIL, "File is empty");
        }

        try {
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            Path path = Paths.get(fileStoragePath + fileName);

            // 确保目标目录存在
            Files.createDirectories(path.getParent());

            // 保存文件
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            String fileUrl = fileBaseUrl + fileName;
            return Result.success(fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.failure(ResultCodeEnum.FAIL, "File upload failed");
        }
    }
}
