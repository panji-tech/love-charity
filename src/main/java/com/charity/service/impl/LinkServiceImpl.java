package com.charity.service.impl;

import com.charity.entity.Link;
import com.charity.service.BaseService;
import com.charity.service.LinkService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("linkService")
public class LinkServiceImpl extends BaseService implements LinkService {

    /**
     * 添加Link
     *
     * @param link 实例对象
     * @return 是否成功
     */
    @Override
    public boolean insert(Link link) {
        return linkMapper.insert(link) == 1;
    }

    /**
     * 删除Link
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return linkMapper.deleteById(id) == 1;
    }

    /**
     * 查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Link getById(Integer id) {
        return linkMapper.getById(id);
    }

    /**
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     *
     * @return 对象列表
     */
    @Override
    public List<Link> listLinks() {
        return linkMapper.listLinks();
    }

    /**
     * 实体作为筛选条件查询数据
     *
     * @param link 实例对象
     * @return 对象列表
     */
    @Override
    public List<Link> listLinks(Link link) {
        return linkMapper.listLinks(link);
    }

    /**
     * 修改数据，哪个属性不为空就修改哪个属性
     *
     * @param link 实例对象
     * @return 是否成功
     */
    @Override
    public boolean update(Link link) {
        return linkMapper.update(link) == 1;
    }

}