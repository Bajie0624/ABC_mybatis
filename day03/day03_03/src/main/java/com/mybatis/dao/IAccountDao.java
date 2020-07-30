package com.mybatis.dao;

import com.mybatis.domain.Account;
import com.mybatis.domain.AccountUser;

import java.util.List;

/**
 * @author Bajie
 * @date 2020/7/28 8:43 下午
 */
public interface IAccountDao {


    //查询所有账户
    List<Account> findAll();

    //查询所有账户，并且带有用户名称和地址信息

    List<AccountUser>findAllAccount();


}
