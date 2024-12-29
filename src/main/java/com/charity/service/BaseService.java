package com.charity.service;

import com.charity.mapper.*;

import javax.annotation.Resource;


public class BaseService {

    @Resource
    protected ArticleActivityMapper articleActivityMapper;

    @Resource
    protected ArticleMapper articleMapper;

    @Resource
    protected CertificationMapper certificationMapper;

    @Resource
    protected CommentMapper commentMapper;

    @Resource
    protected FeedbackMapper feedbackMapper;

    @Resource
    protected LinkMapper linkMapper;

    @Resource
    protected MessageMapper messageMapper;

    @Resource
    protected ProjectMapper projectMapper;

    @Resource
    protected UserMapper userMapper;

    @Resource
    protected MessageBoardMapper messageBoardMapper;

}
