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
public class Feedback implements Serializable {

    private static final long serialVersionUID = -63874957344066512L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 反馈的用户的ID
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
     * 评论内容
     */
    private String content;

    /**
     * 插入数据的时间，即发表评论的时间
     */
    private Date gmtCreate;

    /**
     * 更新的时间
     */
    private Date gmtModified;

}