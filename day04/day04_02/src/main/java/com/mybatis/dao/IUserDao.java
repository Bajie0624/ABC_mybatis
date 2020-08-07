package com.mybatis.dao;

import com.mybatis.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Bajie
 * @date 2020/8/7 9:40 下午
 */
public interface IUserDao {
    //查询所有用户
    @Select("select * from user")
    List<User> findAll();
}
