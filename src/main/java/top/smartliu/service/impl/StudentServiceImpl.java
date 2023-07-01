package top.smartliu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.smartliu.dao.StudentDao;
import top.smartliu.service.StudentService;

import java.io.IOException;

public class StudentServiceImpl implements StudentService {
    // @Autowired
    // private StudentDao studentDao;

    public void test() throws IOException {
        System.out.println("batis service test");
        // studentDao.test();
    }
}
