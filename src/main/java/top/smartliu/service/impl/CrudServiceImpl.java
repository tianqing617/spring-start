package top.smartliu.service.impl;

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
    public void txDemo() {
        crudDao.updateDemo(3, 111);
        int error = 1 / 0;
        crudDao.updateDemo(4, 44);
    }
}
