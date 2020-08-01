package com.mybatis.dao;

import com.mybatis.domain.Role;

import java.util.List;

/**
 * @author Bajie
 * @date 2020/8/1 1:24 下午
 */
public interface IRoleDao {
    //查询所有角色
    List<Role> findAll();
}
