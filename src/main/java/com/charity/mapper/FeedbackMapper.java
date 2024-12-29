package com.charity.mapper;

import com.charity.entity.Feedback;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface FeedbackMapper {

    /**
     * 添加Feedback
     *
     * @param feedback 实例对象
     * @return 影响行数
     */
    int insert(Feedback feedback);

    /**
     * 删除Feedback
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

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
     * 修改Feedback，根据 feedback 的主键修改数据
     *
     * @param feedback
     * @return 影响行数
     */
    int update(Feedback feedback);

}