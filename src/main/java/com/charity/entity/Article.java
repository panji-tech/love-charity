package com.charity.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article implements Serializable {

    private static final long serialVersionUID = 591577028509822181L;

    /**
     * 文章ID
     */
    private Integer id;

    /**
     * 作者用户ID
     */
    private Integer userId;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章正文
     */
    private String content;

    /**
     * 文章状态：发布（1），回收站（2）
     */
    private Integer status;

    /**
     * 阅读量
     */
    private Integer readCount;

    /**
     * 封面图片
     */
    private String img;

    /**
     * 类型：文章（1），活动（2）
     */
    private Integer type;

    /**
     * 文章审核，0：未审核，1：审核通过，2：审核不通过
     */
    private Integer isChecked;

    /**
     * 审核未通过返回的消息
     */
    private String info;

    /**
     * 数据插入时间，即发布时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;

}