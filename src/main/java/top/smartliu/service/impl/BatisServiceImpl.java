package top.smartliu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.smartliu.dao.BatisDao;
import top.smartliu.service.BatisService;

import java.io.IOException;

public class BatisServiceImpl implements BatisService {
    @Autowired
    private BatisDao batisDao;

    public void test() throws IOException {
        System.out.println("batis service test");
        batisDao.test();
    }
}
