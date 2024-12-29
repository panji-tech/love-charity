package com.charity.controller;

import com.alibaba.fastjson.JSONObject;
import com.charity.constant.CheckStatus;
import com.charity.constant.CommentType;
import com.charity.constant.TrashStatus;
import com.charity.constant.TypeStatus;
import com.charity.dto.ResponseResult;
import com.charity.entity.Article;
import com.charity.entity.Message;
import com.charity.utils.OssUtils;
import com.charity.utils.LogUtils;
import com.charity.utils.MessageUtils;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 文章控制器
 * <p>

 *
 * 
 */
@Controller
public class ArticleController extends BaseController {

    private final Logger logger = LogUtils.getInstance(ArticleController.class);

    /**
     * 发布求助文章
     */
    @PostMapping("/publishArticle")
    @ResponseBody
    public String publishArticle(String title, String content, String imgPath, Integer activityId) {
        // 生成文章对象
        Article article = Article.builder()
                .title(title).content(content).userId(loginUser.getId())
                .type(TypeStatus.ARTICLE).readCount(0).status(TrashStatus.NOT_IN).isChecked(CheckStatus.WAIT)
                .gmtCreate(new Date()).gmtModified(new Date())
                .build();
        // 为文章设置封面，如果为空就生成随机封面
        article.setImg(StringUtils.isEmpty(imgPath) ? OssUtils.getRandomFace() : imgPath);
        if (articleService.insert(article)) {
            if (activityId != -1) {
                articleService.insertArticleActivity(article.getId(), activityId);
                logger.info("【成功】：添加文章活动");
            }
            result.setCode(200);
            logger.info("【成功】：添加文章");
        } else {
            result.setCode(500);
            logger.info("【失败】：添加文章");
        }
        return JSONObject.toJSONString(result);
    }

    /**
     * 更新文章
     */
    @PostMapping("/updateArticle")
    @ResponseBody
    public String updateArticle(Integer id, String title, String content, String imgPath, int activityId) {
        // 生成文章对象
        Article article = Article.builder()
                .id(id).title(title).content(content).status(TrashStatus.NOT_IN).isChecked(CheckStatus.WAIT)
                .gmtModified(new Date())
                .build();
        // 为文章设置封面，如果为空就生成随机封面
        article.setImg(StringUtils.isEmpty(imgPath) ? OssUtils.getRandomFace() : imgPath);
        if (articleService.update(article)) {
            if (activityId != -1) {
                // 获取原来参加的活动
                Article activity = articleService.getActivityByArticleId(id);
                if (activity == null || activity.getId() != activityId) {
                    // 删除参与的活动
                    articleService.deleteArticleActivity(id);
                    // 添加新的活动
                    articleService.insertArticleActivity(article.getId(), activityId);
                    logger.info("【成功】：更新文章活动");
                }
            }
            result.setCode(200);
            logger.info("【成功】：更新文章");
        } else {
            result.setCode(500);
            logger.info("【失败】：更新文章");
        }
        return JSONObject.toJSONString(result);
    }

    /**
     * 将文章移到回收站
     */
    @GetMapping("/putIntoTrash")
    public String putIntoTrash(@RequestParam("id") Integer id, @RequestParam("checked") Integer checked) {
        // 获取文章
        Article article = articleService.getById(id);
        if (article.getType() == TypeStatus.ACTIVITY) {
            logger.info("【失败】：将文章移到回收站，类型错误");
            return "error/400";
        }
        if (article.getUserId() != loginUser.getId()) {
            logger.info("【失败】：将文章移到回收站，无权限");
            return "error/401";
        }
        article.setStatus(TrashStatus.IS_IN);
        if (articleService.update(article)) {
            logger.info("【成功】：将文字移到回收站");
        } else {
            logger.info("【失败】：将文字移到回收站");
        }
        return "redirect:/my-articles?checked=" + checked;
    }

    /**
     * 删除文章
     */
    @GetMapping("/deleteArticle")
    public String deleteArticle(@RequestParam("id") Integer id) {
        Article article = articleService.getById(id);
        if (article.getType() == TypeStatus.ACTIVITY) {
            logger.info("【失败】：删除文章，类型错误");
            return "error/400";
        }
        if (article.getUserId() != loginUser.getId()) {
            logger.info("【失败】：删除文章，无权限");
            return "error/401";
        }
        // 删除文章
        if (articleService.deleteById(id)) {
            logger.info("【成功】：删除文章");
            // 删除文章参加的活动
            articleService.deleteArticleActivity(id);
            // 删除评论
            commentService.deleteByTargetIdAndType(id, CommentType.ARTICLE);
        } else {
            logger.info("【失败】：删除文章");
        }
        return "redirect:/trash-article";
    }

    /**
     * 更新文章审核状态
     */
    @PostMapping("/updateArticleIsCheck")
    @ResponseBody
    public ResponseResult updateArticleIsCheck(String isChecked, String info, Integer id) {
        Article article = articleService.getById(id);
        article.setIsChecked(Integer.parseInt(isChecked));
        article.setInfo(info);
        if (articleService.update(article)) {
            //储存消息
            String content = MessageUtils.articleCheckHandle(article.getTitle(), Integer.parseInt(isChecked), info);
            Message message = Message.builder()
                    .receiveUserId(article.getUserId()).sentUserId(loginUser.getId()).type(2)
                    .targetId(id).content(content).gmtCreate(new Date()).sentUserImg(loginUser.getImg())
                    .build();
            if (messageService.insert(message)) {
                logger.info("【成功】：发送审核消息");
                result.setCode(200);
            } else {
                logger.info("【失败】：发送审核消息");
                result.setCode(500);
            }
            logger.info("【成功】：更新文章审核状态");
        } else {
            logger.info("【失败】：更新文章审核状态");
            result.setCode(500);
        }
        return result;
    }
}