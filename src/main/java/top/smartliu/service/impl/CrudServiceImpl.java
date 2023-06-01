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
}
