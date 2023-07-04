package top.smartliu.service.impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import top.smartliu.dao.StudentMapper;
import top.smartliu.domain.User;
import top.smartliu.service.StudentService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    public void test() throws IOException {
        System.out.println("batis service test");
        SqlSession sqlSession = getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        // 1. 基础用法
        // User user = mapper.findById(1);
        // System.out.println(user);

        // 2. 多条件查询
        //模拟条件user
        User condition = new User();
        condition.setUsername("Jim");
        condition.setAge(22);
        List<User> userList = mapper.findByCondition(condition);
        System.out.println(userList);

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
