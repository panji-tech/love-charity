package com.charity.service;

import com.charity.entity.Certification;

import java.util.List;


public interface CertificationService {

    /**
     * 添加Certification
     *
     * @param certification 实例对象
     * @return 是否成功
     */
    boolean insert(Certification certification);

    /**
     * 删除Certification
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
    Certification getById(Integer id);

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
     * 修改数据，哪个属性不为空就修改哪个属性
     *
     * @param certification 实例对象
     * @return 是否成功
     */
    boolean update(Certification certification);

}