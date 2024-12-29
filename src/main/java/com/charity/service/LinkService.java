package com.charity.service;

import com.charity.entity.Link;

import java.util.List;


public interface LinkService {

    /**
     * 添加Link
     *
     * @param link 实例对象
     * @return 是否成功
     */
    boolean insert(Link link);

    /**
     * 删除Link
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
    Link getById(Integer id);

    /**
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     *
     * @return 对象列表
     */
    List<Link> listLinks();

    /**
     * 实体作为筛选条件查询数据
     *
     * @param link 实例对象
     * @return 对象列表
     */
    List<Link> listLinks(Link link);

    /**
     * 修改数据，哪个属性不为空就修改哪个属性
     *
     * @param link 实例对象
     * @return 是否成功
     */
    boolean update(Link link);

}