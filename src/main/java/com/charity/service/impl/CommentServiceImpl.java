package com.charity.service.impl;

import com.charity.entity.Comment;
import com.charity.service.BaseService;
import com.charity.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("commentService")
public class CommentServiceImpl extends BaseService implements CommentService {

    /**
     * @param comment 实例对象
     * @return 是否成功
     * 添加Comment
     */
    @Override
    public boolean insert(Comment comment) {
        return commentMapper.insert(comment) == 1;
    }

    /**
     * @param id 主键
     * @return 是否成功
     * 删除Comment
     */
    @Override
    public boolean deleteById(Integer id) {
        return commentMapper.deleteById(id) == 1;
    }

    /**
     * @param id 主键
     * @return 实例对象
     * 查询单条数据
     */
    @Override
    public Comment getById(Integer id) {
        return commentMapper.getById(id);
    }

    /**
     * @return 对象列表
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     */
    @Override
    public List<Comment> listComments() {
        return commentMapper.listComments();
    }

    /**
     * @param comment 实例对象
     * @return 对象列表
     * 实体作为筛选条件查询数据
     */
    @Override
    public List<Comment> listComments(Comment comment) {
        return commentMapper.listComments(comment);
    }

    /**
     * @param comment 实例对象
     * @return 是否成功
     * 修改数据，哪个属性不为空就修改哪个属性
     */
    @Override
    public boolean update(Comment comment) {
        return commentMapper.update(comment) == 1;
    }

    /**
     * @param articleId 文章ID
     * @return 总数
     * 获取文章的评论数
     */
    @Override
    public Integer countComment(Integer articleId) {
        return commentMapper.countComment(articleId);
    }

    @Override
    public List<Comment> listOneComments(Comment comment) {
        return commentMapper.listOneComments(comment);
    }

    @Override
    public Comment getFirst(Integer id) {
        return commentMapper.getFirst(id);
    }

    @Override
    public int deleteByTargetIdAndType(Integer id, Integer type) {
        return commentMapper.deleteByTargetIdAndType(id, type);
    }

}