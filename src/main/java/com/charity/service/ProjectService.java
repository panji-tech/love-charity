package com.charity.service;

import com.charity.entity.Project;

import java.util.List;


public interface ProjectService {

    /**
     * 添加Project
     *
     * @param project 实例对象
     * @return 是否成功
     */
    boolean insert(Project project);

    /**
     * 删除Project
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
    Project getById(Integer id);

    /**
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     *
     * @return 对象列表
     */
    List<Project> listProjects();

    /**
     * 实体作为筛选条件查询数据
     *
     * @param project 实例对象
     * @return 对象列表
     */
    List<Project> listProjects(Project project);

    /**
     * 修改数据，哪个属性不为空就修改哪个属性
     *
     * @param project 实例对象
     * @return 是否成功
     */
    boolean update(Project project);

}