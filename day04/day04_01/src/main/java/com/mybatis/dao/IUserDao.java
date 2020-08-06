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


    //根据ID查询信息
    User findById(Integer userId);

}
