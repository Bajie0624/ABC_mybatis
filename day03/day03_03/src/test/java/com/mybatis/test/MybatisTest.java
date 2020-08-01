package com.mybatis.test;

import com.mybatis.dao.IUserDao;
import com.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bajie
 * @date 2020/7/24 10:05 下午
 */
public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;
    @Before  //用于在测试方法之前执行
    public void init() throws Exception{
        //读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //使用工厂生产SqlSessionFactory对象
        sqlSession = factory.openSession();
        //使用SqlSessionFactory创建dao接口的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }
    @After //用于在测试方法之后执行
    public void destroy() throws Exception{
        //释放资源
        sqlSession.close();
        in.close();
    }
    @Test
    public void testFindAll()  {
        //使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }






    //测试根据ID查询
    @Test
    public void testFindById(){
        User user = userDao.findById(52);
        System.out.println(user);
        sqlSession.commit();
    }










}
