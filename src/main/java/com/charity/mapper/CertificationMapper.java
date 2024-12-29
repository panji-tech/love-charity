package com.charity.mapper;

import com.charity.entity.Certification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CertificationMapper {

    /**
     * 添加Certification
     *
     * @param certification 实例对象
     * @return 影响行数
     */
    int insert(Certification certification);

    /**
     * 删除Certification
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
    Certification getById(Integer id);

    /**
     * 查询单条数据
     *
     * @param id 用户ID
     * @return 实例对象
     */
    Certification getByUserId(Integer id);

    /**
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     *
     * @return 对象列表
     */
    List<Certification> listCertifications();

    /**
     * 实体作为筛选条件查询数据
     *
     * @param certification 实例对象
     * @return 对象列表
     */
    List<Certification> listCertifications(Certification certification);

    /**
     * 修改Certification，根据 certification 的主键修改数据
     *
     * @param certification
     * @return 影响行数
     */
    int update(Certification certification);

}