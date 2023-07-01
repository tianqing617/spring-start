package top.smartliu.dao;

import top.smartliu.domain.User;

public interface StudentDao {
    User findById(int id);
}
