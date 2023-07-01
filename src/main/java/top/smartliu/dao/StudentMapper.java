package top.smartliu.dao;

import top.smartliu.domain.User;

public interface StudentMapper {
    User findById(int id);
}
