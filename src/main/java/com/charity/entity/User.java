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
public class User implements Serializable {
    private static final long serialVersionUID = -15547846354844048L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 地址
     */
    private String address;
    /**
     * 性别：女（0）男（1）
     */
    private Integer sex;
    /**
     * 出生年月
     */
    private Date birthday;
    /**
     * 职业
     */
    private String career;
    /**
     * 认证ID
     */
    private Integer certificationId;
    /**
     * 头像地址
     */
    private String img;
    /**
     * 状态：正常（0），封禁（1）
     */
    private Integer status;
    /**
     * 注册时间
     */
    private Date gmtCreate;
    /**
     * 最近更新
     */
    private Date gmtModified;
    /**
     * 用户角色：普通用户（0），管理员（1）
     */
    private Integer role;

}