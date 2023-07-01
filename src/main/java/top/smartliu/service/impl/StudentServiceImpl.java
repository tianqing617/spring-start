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

public class StudentServiceImpl implements StudentService {
    public void test() throws IOException {
        System.out.println("batis service test");
        SqlSession sqlSession = getSqlSession();

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        User user = mapper.findById(1);
        System.out.println(user);

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
