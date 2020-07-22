package com.mybatis.mybatis.sqlsession;

//自定义中和数据库交互的核心类，里面可以创建爱dao接口的代理对象

public interface SqlSession {
    //根据参数创建一个对象 dao的字节码
    <T> T getMapper(Class<T> daoInterfaceClass);

    //释放资源

    void close();
}
