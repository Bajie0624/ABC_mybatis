package com.mybatis.test;

import com.mybatis.dao.IUserDao;
import com.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//mybatis的入门
public class MybatisTest {
    //入门案例
    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream in  = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //使用工厂生产SqlSessionFactory对象
        SqlSession session = factory.openSession();
        //使用SqlSessionFactory创建dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
        //释放资源
        session.close();
        in.close();
    }
}
