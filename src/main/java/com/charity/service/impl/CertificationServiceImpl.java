package com.charity.service.impl;

import com.charity.entity.Certification;
import com.charity.service.BaseService;
import com.charity.service.CertificationService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("certificationService")
public class CertificationServiceImpl extends BaseService implements CertificationService {

    /**
     * 添加Certification
     *
     * @param certification 实例对象
     * @return 是否成功
     */
    @Override
    public boolean insert(Certification certification) {
        return certificationMapper.insert(certification) == 1;
    }

    /**
     * 删除Certification
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return certificationMapper.deleteById(id) == 1;
    }

    /**
     * 查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Certification getById(Integer id) {
        return certificationMapper.getById(id);
    }

    /**
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     *
     * @return 对象列表
     */
    @Override
    public List<Certification> listCertifications() {
        return certificationMapper.listCertifications();
    }

    /**
     * 实体作为筛选条件查询数据
     *
     * @param certification 实例对象
     * @return 对象列表
     */
    @Override
    public List<Certification> listCertifications(Certification certification) {
        return certificationMapper.listCertifications(certification);
    }

    /**
     * 修改数据，哪个属性不为空就修改哪个属性
     *
     * @param certification 实例对象
     * @return 是否成功
     */
    @Override
    public boolean update(Certification certification) {
        return certificationMapper.update(certification) == 1;
    }

}