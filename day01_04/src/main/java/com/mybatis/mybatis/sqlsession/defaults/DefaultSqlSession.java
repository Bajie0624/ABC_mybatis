package com.mybatis.mybatis.sqlsession.defaults;

import com.mybatis.mybatis.cfg.Configuration;
import com.mybatis.mybatis.sqlsession.SqlSession;

//sqlSession接口的实现类
public class DefaultSqlSession implements SqlSession {

    private Configuration cfg;

    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;

    }

    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass){
        return null;
    }
    //用于释放对象
    @Override
    public void close(){

    }
}
