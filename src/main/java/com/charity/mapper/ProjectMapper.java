package com.charity.mapper;

import com.charity.entity.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ProjectMapper {

    /**
     * 添加Project
     *
     * @param project 实例对象
     * @return 影响行数
     */
    int insert(Project project);

    /**
     * 删除Project
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
     * 修改Project，根据 project 的主键修改数据
     *
     * @param project
     * @return 影响行数
     */
    int update(Project project);

}