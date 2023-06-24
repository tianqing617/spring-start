package top.smartliu.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import top.smartliu.dao.CrudDao;
import top.smartliu.service.CrudService;

public class CrudServiceImpl implements CrudService {
    private CrudDao crudDao;

    public CrudServiceImpl() {}

    public CrudServiceImpl(CrudDao crudDao) {
        this.crudDao = crudDao;
    }

    @Override
    public void addDemo() {
        System.out.println("crud service");
        crudDao.addDemo();
    }

    // 事务示例
    @Override
    @Transactional(isolation = Isolation.DEFAULT)
    public void txDemo() {
        crudDao.updateDemo(3, 333);
        // int error = 1 / 0;
        crudDao.updateDemo(4, 444);
    }
}
