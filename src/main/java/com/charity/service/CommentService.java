package com.charity.service;

import com.charity.entity.Comment;

import java.util.List;


public interface CommentService {

    /**
     * 添加Comment
     *
     * @param comment 实例对象
     * @return 是否成功
     */
    boolean insert(Comment comment);

    /**
     * 删除Comment
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Comment getById(Integer id);

    /**
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     *
     * @return 对象列表
     */
    List<Comment> listComments();

    /**
     * 实体作为筛选条件查询数据
     *
     * @param comment 实例对象
     * @return 对象列表
     */
    List<Comment> listComments(Comment comment);

    /**
     * 修改数据，哪个属性不为空就修改哪个属性
     *
     * @param comment 实例对象
     * @return 是否成功
     */
    boolean update(Comment comment);

    /**
     * 获取文章的评论数
     *
     * @param articleId 文章ID
     * @return 总数
     */
    Integer countComment(Integer articleId);

    /**
     * 　* : 通过目标id获得文章的一级评论
     * 　* @Author LiMeiyue
     * 　* @date 2020/10/19 21:06
     * 　* @Param [comment]
     * 　* @Return java.util.List<com.charity.entity.Comment>
     */
    List<Comment> listOneComments(Comment comment);

    /**
     * 获取目标的指定评论
     */
    Comment getFirst(Integer id);

    /**
     * 根据目标ID和类型删除评论
     */
    int deleteByTargetIdAndType(Integer id, Integer type);
}