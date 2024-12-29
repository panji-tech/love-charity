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
public class ArticleActivity implements Serializable {

    private static final long serialVersionUID = -20737493830476356L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 文章的ID
     */
    private Integer articleId;

    /**
     * 活动文章的ID
     */
    private Integer activityArticleId;

    /**
     * 插入数据的时间
     */
    private Date gmtCreate;

    /**
     * 更新的时间
     */
    private Date gmtModified;

}