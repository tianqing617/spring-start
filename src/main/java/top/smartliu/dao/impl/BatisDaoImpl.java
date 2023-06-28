package top.smartliu.dao.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import top.smartliu.dao.BatisDao;
import top.smartliu.domain.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BatisDaoImpl implements BatisDao {
    public void test() throws IOException {
        System.out.println("batis dao test");

        SqlSession sqlSession = getSqlSession();

        // 执行SQL语句
        // 1. 查询
        // List<User> userList = sqlSession.selectList("userMapper.selectAll");
        // System.out.println(userList);
        // 2. 新增
        // testInsert();
        // 3. 更新
        // testUpdate();
        // 4. 删除
        testDelete();
        // 释放资源
        sqlSession.close();
    }

    public void testDelete() throws IOException {
        SqlSession sqlSession = getSqlSession();
        // 形参一：userMapper.delete 表示：命名空间.id
        // 形参二：支持传入id；支持传入Object，按多条件过滤删除
        sqlSession.delete("userMapper.delete", 8);
        // 需要手动提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    public void testUpdate() throws IOException {
        User user = new User();
        user.setId(4);
        user.setUsername("海汇");
        user.setAge(30);

        SqlSession sqlSession = getSqlSession();
        sqlSession.update("userMapper.update", user);
        sqlSession.commit();
        sqlSession.close();
    }

    public void testInsert() throws IOException {
        User user = new User();
        user.setUsername("盛华里");
        user.setAge(33);

        SqlSession sqlSession = getSqlSession();
        sqlSession.insert("userMapper.insert", user);
        sqlSession.commit();
        sqlSession.close();
    }

    private SqlSession getSqlSession() throws IOException {
        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        // 获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 获取SqlSession对象
        return sqlSessionFactory.openSession();
    }
}
