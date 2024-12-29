package com.charity.controller;

import com.charity.dto.ResponseResult;
import com.charity.entity.Feedback;
import com.charity.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 反馈控制器
 * <p>

 *
 * 
 */
@RestController
public class FeedBackController extends BaseController {

    private final Logger logger = LogUtils.getInstance(FeedBackController.class);

    /**
     * 已登录用户发表反馈
     */
    @PostMapping("/publishFeedback")
    public ResponseResult publishFeedback(@RequestParam("content") String content) {
        Feedback feedback = Feedback.builder().userName(loginUser.getName())
                .img(loginUser.getImg()).content(content).gmtCreate(new Date()).userId(loginUser.getId()).build();
        boolean insert = feedbackService.insert(feedback);
        if (insert) {
            result.setCode(200);
        } else {
            result.setCode(301);
        }
        return result;
    }

    /**
     * 根据id删除反馈
     */
    @GetMapping("/deleteFeedBack")
    public ResponseResult deleteFeedBack(Integer id) {
        boolean b = feedbackService.deleteById(id);
        if (b) {
            result.setCode(200);
        } else {
            result.setCode(500);
        }
        return result;
    }
}
