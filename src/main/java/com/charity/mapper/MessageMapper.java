package com.charity.mapper;

import com.charity.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MessageMapper {

    /**
     * 添加Message
     *
     * @param message 实例对象
     * @return 影响行数
     */
    int insert(Message message);

    /**
     * 删除Message
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
     * 修改Message，根据 message 的主键修改数据
     *
     * @param message
     * @return 影响行数
     */
    int update(Message message);

    /**
     * 　* : 删除用户id的所有消息
     * 　* @Author LiMeiyue
     * 　* @date 2020/10/19 21:39
     * 　* @Param [id]
     * 　* @Return boolean
     */
    boolean deleteAllByUserId(Integer id);
}