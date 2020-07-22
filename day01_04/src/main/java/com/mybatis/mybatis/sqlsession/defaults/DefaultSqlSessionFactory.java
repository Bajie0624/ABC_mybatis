package com.mybatis.mybatis.sqlsession.defaults;

import com.mybatis.mybatis.cfg.Configuration;
import com.mybatis.mybatis.sqlsession.SqlSession;
import com.mybatis.mybatis.sqlsession.SqlSessionFactory;

//SqlSessionFactory接口实现类

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }
    //用于创建一个新的数据库对象


    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
