package com.charity.controller;

import com.alibaba.fastjson.JSONObject;
import com.charity.dto.ResponseResult;
import com.charity.utils.LocalFileUtils;
import com.charity.utils.LogUtils;
import com.charity.utils.OssUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 图片控制器
 * <p>
 */
@RestController
@RequestMapping("/image")
public class ImageController extends BaseController {
    @Resource
    private LocalFileUtils localFileUtils;

    @Value("${file.upload.ossEnable}")
    private Boolean ossEnable;

    private final Logger logger = LogUtils.getInstance(ImageController.class);

    /**
     * 图片上传
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("image") MultipartFile file) throws IOException {
        if (!OssUtils.checkFileSize(file.getSize(), 1, "M")) {
            result.setCode(502);
            return JSONObject.toJSONString(result);
        }
//        String url = OssUtils.upload(file, "o");
        String url = ossEnable ? OssUtils.upload(file, "o") : localFileUtils.upload(file);
        if (url != null) {
            result.setUrl(url);
            result.setSuccess(1);
            logger.warn("【成功】文章上传图片，URL：" + url);
        } else {
            logger.warn("【失败】文章上传图片");
        }
        // 返回结果
        result.setCode(200);
        result.setData(url);
        return JSONObject.toJSONString(result);
    }

    /**
     * 文章图片上传到码云图床
     */
    @PostMapping("/article")
    public ResponseResult uploadArticleImg(@RequestParam("editormd-image-file") MultipartFile file) throws IOException {
//        String url = OssUtils.upload(file, "article");
        String url = ossEnable ? OssUtils.upload(file, "article") : localFileUtils.upload(file);
        if (url != null) {
            result.setUrl(url);
            result.setSuccess(1);
            logger.warn("【成功】文章上传图片，URL：" + url);
        } else {
            logger.warn("【失败】文章上传图片");
        }
        return result;
    }

    /**
     * 上传用户头像
     */
    @PostMapping("/user")
    public ResponseResult uploadUserImg(@RequestParam("file") MultipartFile file) throws IOException {
        String url = ossEnable ? OssUtils.upload(file, "user") : localFileUtils.upload(file);

        loginUser.setImg(url);
        if (userService.update(loginUser)) {
            logger.info("用户" + loginUser.getName() + "上传头像成功，路径为" + url);
            result.setCode(200);
            result.setData(url);
        } else {
            logger.info("用户" + loginUser.getName() + "上传头像失败！");
            result.setCode(500);
        }
        return result;
    }


}
