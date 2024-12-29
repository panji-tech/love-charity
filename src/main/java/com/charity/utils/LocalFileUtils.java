package com.charity.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

@Component
public class LocalFileUtils {

    @Value("${server.servlet.context-path}")
    private String contextPath;

    public String upload(MultipartFile file) {
        if (file.isEmpty()) {
            throw new RuntimeException("上传文件不能为空");
        }
        String rootPath = PathUtils.getClassLoadRootPath();
        File path = new File(rootPath);
        if (!path.exists()) {
            path = new File("");
        }
        File upload = new File(path.getAbsolutePath(), "/upload/");
        if (!upload.exists()) {
            upload.mkdirs();
        }
        // 文件后缀
        String fileExt = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        // 生成新的文件名
        String fileName = new Date().getTime() + "." + fileExt;
        // 创建 file对象
        File dest = new File(upload.getAbsolutePath() + "/" + fileName);
        try {
            // 把浏览器上传的文件复制到希望的位置
            file.transferTo(dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String imgPath = contextPath + "/upload/" + fileName;
        return imgPath;
    }
}
