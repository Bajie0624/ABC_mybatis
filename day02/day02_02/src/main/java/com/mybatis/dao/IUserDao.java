package com.mybatis.dao;

import com.mybatis.domain.User;

import java.util.List;

/**
 * @author Bajie
 * @date 2020/7/24 9:57 下午
 */
//用户的持久层接口
public interface IUserDao {
    //查询所有操作
    List<User> findAll();

    //保存操作
    void saveUser(User user);


    //更新操作
    void updateUser(User user);

    //删除操作
    void deleteUser(Integer userId);

    //根据ID查询信息
    User findById(Integer userId);

    //根据名称模糊查询用户信息
    List<User> findByName(String username);

    //查询总记录条数
    int findTotal();

}
