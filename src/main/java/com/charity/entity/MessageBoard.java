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
public class MessageBoard implements Serializable {

    private static final long serialVersionUID = -52264605625410469L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 昵称
     */
    private String name;

    /**
     * 邮件地址
     */
    private String email;

    /**
     * 留言内容
     */
    private String content;

    /**
     * 插入数据的时间
     */
    private Date gmtCreate;

    /**
     * 更新的时间
     */
    private Date gmtModified;

}