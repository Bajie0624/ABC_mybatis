package com.mybatis.mybatis.sqlsession;

//用于创建一个SqlSessionFactoryBuilder对象

import com.mybatis.mybatis.cfg.Configuration;
import com.mybatis.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.mybatis.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {

    //构建一个SqlSessionFactory工厂

    public DefaultSqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
