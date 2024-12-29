package com.charity.service.impl;

import com.charity.entity.MessageBoard;
import com.charity.service.BaseService;
import com.charity.service.MessageBoardService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("messageBoardService")
public class MessageBoardServiceImpl extends BaseService implements MessageBoardService {

    /**
     * 添加MessageBoard
     *
     * @param messageBoard 实例对象
     * @return 是否成功
     */
    @Override
    public boolean insert(MessageBoard messageBoard) {
        return messageBoardMapper.insert(messageBoard) == 1;
    }

    /**
     * 删除MessageBoard
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return messageBoardMapper.deleteById(id) == 1;
    }

    /**
     * 查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public MessageBoard getById(Integer id) {
        return messageBoardMapper.getById(id);
    }

    /**
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     *
     * @return 对象列表
     */
    @Override
    public List<MessageBoard> listMessageBoards() {
        return messageBoardMapper.listMessageBoards();
    }

    /**
     * 实体作为筛选条件查询数据
     *
     * @param messageBoard 实例对象
     * @return 对象列表
     */
    @Override
    public List<MessageBoard> listMessageBoards(MessageBoard messageBoard) {
        return messageBoardMapper.listMessageBoards(messageBoard);
    }

    /**
     * 修改数据，哪个属性不为空就修改哪个属性
     *
     * @param messageBoard 实例对象
     * @return 是否成功
     */
    @Override
    public boolean update(MessageBoard messageBoard) {
        return messageBoardMapper.update(messageBoard) == 1;
    }

}