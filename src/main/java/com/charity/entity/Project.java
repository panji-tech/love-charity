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
public class Project implements Serializable {

    private static final long serialVersionUID = 407192645049637331L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 背景
     */
    private String background;

    /**
     * 目的
     */
    private String target;

    /**
     * 主题
     */
    private String theme;

    /**
     * 赞助
     */
    private String sponsor;

    /**
     * 内容
     */
    private String content;

    /**
     * 公益项目的封面
     */
    private String img;

    /**
     * 插入数据的时间
     */
    private Date gmtCreate;

    /**
     * 更新的时间
     */
    private Date gmtModified;

}