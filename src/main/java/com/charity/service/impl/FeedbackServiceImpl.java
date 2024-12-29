package com.charity.service.impl;

import com.charity.entity.Feedback;
import com.charity.service.BaseService;
import com.charity.service.FeedbackService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("feedbackService")
public class FeedbackServiceImpl extends BaseService implements FeedbackService {

    /**
     * 添加Feedback
     *
     * @param feedback 实例对象
     * @return 是否成功
     */
    @Override
    public boolean insert(Feedback feedback) {
        return feedbackMapper.insert(feedback) == 1;
    }

    /**
     * 删除Feedback
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return feedbackMapper.deleteById(id) == 1;
    }

    /**
     * 查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Feedback getById(Integer id) {
        return feedbackMapper.getById(id);
    }

    /**
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     *
     * @return 对象列表
     */
    @Override
    public List<Feedback> listFeedbacks() {
        return feedbackMapper.listFeedbacks();
    }

    /**
     * 实体作为筛选条件查询数据
     *
     * @param feedback 实例对象
     * @return 对象列表
     */
    @Override
    public List<Feedback> listFeedbacks(Feedback feedback) {
        return feedbackMapper.listFeedbacks(feedback);
    }

    /**
     * 修改数据，哪个属性不为空就修改哪个属性
     *
     * @param feedback 实例对象
     * @return 是否成功
     */
    @Override
    public boolean update(Feedback feedback) {
        return feedbackMapper.update(feedback) == 1;
    }

}