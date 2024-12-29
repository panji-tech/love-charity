package com.charity.controller;

import com.charity.dto.ResponseResult;
import com.charity.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息控制器
 * <p>

 *
 * 
 */
@RestController
public class MessageController extends BaseController {


    private final Logger logger = LogUtils.getInstance(MessageController.class);

    /**
     * 设置某用户全部消息设置为已读
     */
    @PostMapping("/updateMessageIsRead")
    public ResponseResult updateMessageIsRead(Integer id) {
        if (messageService.deleteAllByUserId(id)) {
            result.setCode(200);
            session.removeAttribute("messages");
            logger.info("用户" + loginUser.getName() + "设置消息全部已读成功!");

        } else {
            result.setCode(500);
            logger.error("用户" + loginUser.getName() + "设置消息全部已读失败!");
        }
        return result;
    }

    /**
     * 删除该用户的全部消息
     */
    @PostMapping("/delMessage")
    public ResponseResult delMessage(Integer id) {

        if (messageService.deleteAllByUserId(id)) {
            logger.info("删除用户" + loginUser.getName() + "全部消息成功!");
            result.setCode(200);
        } else {
            logger.error("删除用户" + loginUser.getName() + "全部消息失败!");
            result.setCode(500);
        }
        return result;
    }
}
