package com.charity.service.impl;

import com.charity.entity.Project;
import com.charity.service.BaseService;
import com.charity.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("projectService")
public class ProjectServiceImpl extends BaseService implements ProjectService {

    /**
     * 添加Project
     *
     * @param project 实例对象
     * @return 是否成功
     */
    @Override
    public boolean insert(Project project) {
        return projectMapper.insert(project) == 1;
    }

    /**
     * 删除Project
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return projectMapper.deleteById(id) == 1;
    }

    /**
     * 查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Project getById(Integer id) {
        return projectMapper.getById(id);
    }

    /**
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     *
     * @return 对象列表
     */
    @Override
    public List<Project> listProjects() {
        return projectMapper.listProjects();
    }

    /**
     * 实体作为筛选条件查询数据
     *
     * @param project 实例对象
     * @return 对象列表
     */
    @Override
    public List<Project> listProjects(Project project) {
        return projectMapper.listProjects(project);
    }

    /**
     * 修改数据，哪个属性不为空就修改哪个属性
     *
     * @param project 实例对象
     * @return 是否成功
     */
    @Override
    public boolean update(Project project) {
        return projectMapper.update(project) == 1;
    }

}