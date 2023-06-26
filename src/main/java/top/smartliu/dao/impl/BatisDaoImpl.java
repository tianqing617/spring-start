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

        // 加载核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        // 获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        // 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行SQL语句
        List<User> userList = sqlSession.selectList("userMapper.selectAll");

        // 打印结果
        System.out.println(userList);

        // 释放资源
        sqlSession.close();
    }
}
