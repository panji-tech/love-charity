package com.charity.service;

import com.charity.entity.Message;

import java.util.List;


public interface MessageService {

    /**
     * 添加Message
     *
     * @param message 实例对象
     * @return 是否成功
     */
    boolean insert(Message message);

    /**
     * 删除Message
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
    Message getById(Integer id);

    /**
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     *
     * @return 对象列表
     */
    List<Message> listMessages();

    /**
     * 实体作为筛选条件查询数据
     *
     * @param message 实例对象
     * @return 对象列表
     */
    List<Message> listMessages(Message message);

    /**
     * 修改数据，哪个属性不为空就修改哪个属性
     *
     * @param message 实例对象
     * @return 是否成功
     */
    boolean update(Message message);

    /**
     * 　* : 删除用户id的所有消息记录
     * 　* @Author LiMeiyue
     * 　* @date 2020/10/19 21:38
     * 　* @Param [id]
     * 　* @Return boolean
     */
    boolean deleteAllByUserId(Integer id);
}