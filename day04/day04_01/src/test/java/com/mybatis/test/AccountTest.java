package com.mybatis.test;

import com.mybatis.dao.IAccountDao;
import com.mybatis.domain.Account;
import com.mybatis.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author Bajie
 * @date 2020/7/28 8:47 下午
 */
public class AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accountDao;
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
        accountDao = sqlSession.getMapper(IAccountDao.class);
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
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }

    }

    @Test
    public void findAllAccount()  {
        //使用代理对象执行方法
        List<AccountUser> aus = accountDao.findAllAccount();
        for (AccountUser au : aus) {
            System.out.println(au);
        }

    }


}
