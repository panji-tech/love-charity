package com.charity.controller;

import com.alibaba.fastjson.JSONObject;
import com.charity.entity.Link;
import com.charity.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 链接控制器
 * <p>

 *
 * 
 */
@RestController
public class LinkController extends BaseController {

    private final Logger logger = LogUtils.getInstance(LinkController.class);

    /**
     * 删除链接
     */
    @GetMapping("/deleteLink")
    public String deleteLink(@RequestParam("id") Integer id) {
        if (linkService.deleteById(id)) {
            logger.info("【成功】：删除链接");
            result.setCode(200);
        } else {
            logger.info("【失败】：删除链接");
            result.setCode(500);
        }
        return JSONObject.toJSONString(result);
    }

    /**
     * 添加菜单/友情链接
     */
    @PostMapping("/addLink")
    public String addLink(@RequestParam("name") String name, @RequestParam("url") String url, @RequestParam("type") Integer type) {
        // 生成链接对象
        Link link = Link.builder()
                .name(name).targetUrl(url).type(type).gmtCreate(new Date())
                .build();
        if (linkService.insert(link)) {
            logger.info("【成功】：添加菜单/友情链接");
            result.setCode(200);
        } else {
            logger.info("【失败】：添加菜单/友情链接");
            result.setCode(500);
        }
        return JSONObject.toJSONString(result);
    }
}
