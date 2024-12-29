package com.charity.service;

import com.charity.entity.MessageBoard;

import java.util.List;


public interface MessageBoardService {

    /**
     * 添加MessageBoard
     *
     * @param messageBoard 实例对象
     * @return 是否成功
     */
    boolean insert(MessageBoard messageBoard);

    /**
     * 删除MessageBoard
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
    MessageBoard getById(Integer id);

    /**
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     *
     * @return 对象列表
     */
    List<MessageBoard> listMessageBoards();

    /**
     * 实体作为筛选条件查询数据
     *
     * @param messageBoard 实例对象
     * @return 对象列表
     */
    List<MessageBoard> listMessageBoards(MessageBoard messageBoard);

    /**
     * 修改数据，哪个属性不为空就修改哪个属性
     *
     * @param messageBoard 实例对象
     * @return 是否成功
     */
    boolean update(MessageBoard messageBoard);

}