package com.charity.controller;

import com.alibaba.fastjson.JSONObject;
import com.charity.entity.MessageBoard;
import com.charity.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 留言板控制器
 * <p>

 *
 * 
 */
@RestController
public class BoardController extends BaseController {

    private final Logger logger = LogUtils.getInstance(BoardController.class);

    /**
     * 发表留言
     */
    @PostMapping("/publishMessage")
    public String publishMessage(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("content") String content) {
        // 构建留言对象
        MessageBoard message = MessageBoard.builder()
                .name(name).email(email).content(content).gmtCreate(new Date())
                .build();
        if (boardService.insert(message)) {
            logger.info("【成功】，发表留言");
            result.setCode(200);
        } else {
            logger.info("【失败】，发表留言");
            result.setCode(500);
        }
        return JSONObject.toJSONString(result);
    }

    /**
     * 删除留言
     */
    @GetMapping("/deleteBoard")
    public String deleteBoard(@RequestParam("id") Integer id) {
        if (boardService.deleteById(id)) {
            logger.info("【成功】，删除留言");
            result.setCode(200);
        } else {
            logger.info("【失败】，删除留言");
            result.setCode(500);
        }
        return JSONObject.toJSONString(result);
    }
}
