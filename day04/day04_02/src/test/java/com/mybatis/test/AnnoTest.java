package com.mybatis.test;


import com.mybatis.dao.IUserDao;
import com.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author Bajie
 * @date 2020/8/7 10:01 下午
 */
public class AnnoTest {
    public static void main(String[] args) throws Exception {
        //获取字节流
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //根据输入字节流构建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //根据SQLSessionFactory生产一个SqlSession
        SqlSession session = factory.openSession();
        //使用SqlSession获取Dao代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //执行Dao方法
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
        //释放资源
        session.close();
        in.close();

    }
}
