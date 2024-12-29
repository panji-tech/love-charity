package com.charity.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment implements Serializable {

    private static final long serialVersionUID = -63892952404673226L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 发表评论用户的ID
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户头像地址
     */
    private String img;

    /**
     * 目标ID：可以是项目ID 、文章ID
     */
    private Integer targetId;

    /**
     * 类型：项目（1），文章（2）
     */
    private Integer type;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 回复评论的ID
     */
    private Integer replyId;

    /**
     * 是否置顶：置顶（1），不置顶（0）
     */
    private Integer isFirst;

    /**
     * 插入数据的时间，即发表评论的时间
     */
    private Date gmtCreate;

    /**
     * 更新的时间
     */
    private Date gmtModified;

    /**
     * 所有回复的评论
     */
    private List<Comment> replyComments;

}