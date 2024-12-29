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
public class Link implements Serializable {

    private static final long serialVersionUID = -32049554348278974L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 链接地址
     */
    private String targetUrl;

    /**
     * 类型：顶部菜单（1），友情链接（2）
     */
    private Integer type;

    /**
     * 插入数据的时间
     */
    private Date gmtCreate;

    /**
     * 更新的时间
     */
    private Date gmtModified;

}