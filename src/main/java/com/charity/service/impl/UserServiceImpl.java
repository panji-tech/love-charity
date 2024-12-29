package com.charity.service.impl;

import com.charity.entity.User;
import com.charity.service.BaseService;
import com.charity.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl extends BaseService implements UserService {

    /**
     * 添加User
     *
     * @param user 实例对象
     * @return 是否成功
     */
    @Override
    public boolean insert(User user) {
        return userMapper.insert(user) == 1;
    }

    /**
     * 删除User
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return userMapper.deleteById(id) == 1;
    }

    /**
     * 查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    /**
     * 查询全部数据
     * 分页使用MyBatis的插件实现
     *
     * @return 对象列表
     */
    @Override
    public List<User> listUsers() {
        return userMapper.listUsers();
    }

    /**
     * 实体作为筛选条件查询数据
     *
     * @param user 实例对象
     * @return 对象列表
     */
    @Override
    public List<User> listUsers(User user) {
        return userMapper.listUsers(user);
    }

    /**
     * 修改数据，哪个属性不为空就修改哪个属性
     *
     * @param user 实例对象
     * @return 是否成功
     */
    @Override
    public boolean update(User user) {
        return userMapper.update(user) == 1;
    }

    @Override
    public User getUserByEmail(String email) {
        return this.userMapper.getUserByEmail(email);
    }

    @Override
    public User getUserByUserName(String param) {
        return this.userMapper.getUserByName(param);
    }

    @Override
    public boolean updatePwdByEmail(User user) {
        return userMapper.updatePwdByEmail(user) == 1;
    }

    @Override
    public int deleteCertification(Integer id) {
        return userMapper.deleteCertification(id);
    }

}