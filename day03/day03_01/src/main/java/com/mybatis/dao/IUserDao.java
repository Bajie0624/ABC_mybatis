package com.mybatis.dao;

import com.mybatis.domain.QueryVo;
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

    //根据名称模糊查询用户信息
    List<User> findByName(String username);

    //用queryVo方式查询
    List<User> findUserByVo(QueryVo vo);

    //根据传入的参数条件查询
    //user是查询的条件 有可能有用户名 有可能有性别 也有可能有地址  还有可能都有
    List<User> findUserByCondition(User user);

    //根据id集合查询信息
    List<User> findUserInIds(QueryVo vo);
}
