package com.charity.service;

import com.charity.entity.Feedback;

import java.util.List;


public interface FeedbackService {

    /**
     * 添加Feedback
     *
     * @param feedback 实例对象
     * @return 是否成功
     */
    boolean insert(Feedback feedback);

    /**
     * 删除Feedback
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
    Feedback getById(Integer id);

    /**
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     *
     * @return 对象列表
     */
    List<Feedback> listFeedbacks();

    /**
     * 实体作为筛选条件查询数据
     *
     * @param feedback 实例对象
     * @return 对象列表
     */
    List<Feedback> listFeedbacks(Feedback feedback);

    /**
     * 修改数据，哪个属性不为空就修改哪个属性
     *
     * @param feedback 实例对象
     * @return 是否成功
     */
    boolean update(Feedback feedback);

}