package com.mybatis.dao.impl;

import com.mybatis.dao.IUserDao;
import com.mybatis.domain.User;
import com.mysql.cj.Session;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author Bajie
 * @date 2020/7/26 12:03 上午
 */
public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;
    //通过构造函数保证factory一定是有值得
    public UserDaoImpl(SqlSessionFactory factory){

        this.factory = factory;
    }
    @Override
    public List<User> findAll() {
        //根据factory获取SqlSession对象
        SqlSession  session = factory.openSession();
        //调用SqlSession中的方法，实现查询列表
        List<User> users =  session.selectList("com.mybatis.dao.IUserDao.findAll");
        //释放资源
        session.close();
        return users;
    }
    @Override
    public void saveUser(User user) {
        SqlSession session = factory.openSession();
        session.insert("com.mybatis.dao.IUserDao.saveUser",user);
        session.commit();//提交事务
        session.close();

    }

    public void updateUser(User user) {
        SqlSession session = factory.openSession();
        session.update("com.mybatis.dao.IUserDao.updateUser",user);
        session.commit();//提交事务
        session.close();
    }

    public void deleteUser(Integer userId) {
        SqlSession session = factory.openSession();
        session.delete("com.mybatis.dao.IUserDao.deleteUser",userId);
        session.commit();//提交事务
        session.close();
    }

    public User findById(Integer userId) {
        SqlSession session = factory.openSession();
        User user =  session.selectOne("com.mybatis.dao.IUserDao.findById",userId);
        session.close();
        return user;
    }

    public List<User> findByName(String username) {
        SqlSession session = factory.openSession();
        List<User> user = session.selectList("com.mybatis.dao.IUserDao.findByName",username);
        session.close();
        return user;
    }

    public int findTotal() {
        SqlSession session = factory.openSession();
        Integer count = session.selectOne("com.mybatis.dao.IUserDao.findTotal");
        session.close();
        return count;
    }
}
