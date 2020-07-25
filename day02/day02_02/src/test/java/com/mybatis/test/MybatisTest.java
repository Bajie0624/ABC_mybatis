package com.mybatis.test;

import com.mybatis.dao.IUserDao;
import com.mybatis.dao.impl.UserDaoImpl;
import com.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
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
        //使用工厂创建dao对象
        userDao = new UserDaoImpl(factory);

    }
    @After //用于在测试方法之后执行
    public void destroy() throws Exception{
        //释放资源
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

//    测试保存操作
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("DongMei");
        user.setAddress("Chengdu");
        user.setSex("女");
        user.setBirthday(new Date());
        //使用保存方法
        userDao.saveUser(user);
        //提交事务

    }

    //测试更新操作
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(53);
        user.setUsername("Zhou");
        user.setAddress("Nanjing");
        user.setSex("女");
        user.setBirthday(new Date());
        userDao.updateUser(user);
    }

    //测试删除操作
    @Test
    public void testDelete(){
        //执行删除方法
        userDao.deleteUser(54);
    }


    //测试根据ID查询
    @Test
    public void testFindById(){
        User user = userDao.findById(52);
        System.out.println(user);
    }


    //测试名称查询
    @Test
    public void testFindByName(){
        List<User> users = userDao.findByName("%zhao%");
        System.out.println(users);
    }

    //测试查询总记录条数
    @Test
    public void testFindTotal(){
        int count = userDao.findTotal();
        System.out.println(count);
    }



}
