package com.charity.mapper;

import com.charity.entity.MessageBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MessageBoardMapper {

    /**
     * 添加MessageBoard
     *
     * @param messageBoard 实例对象
     * @return 影响行数
     */
    int insert(MessageBoard messageBoard);

    /**
     * 删除MessageBoard
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
     * 修改MessageBoard，根据 messageBoard 的主键修改数据
     *
     * @param messageBoard
     * @return 影响行数
     */
    int update(MessageBoard messageBoard);

}