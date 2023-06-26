package top.smartliu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.smartliu.dao.BatisDao;
import top.smartliu.service.BatisService;

public class BatisServiceImpl implements BatisService {
    @Autowired
    private BatisDao batisDao;

    public void test() {
        System.out.println("batis service test");
        batisDao.test();
    }
}
