package top.smartliu.dao;

import top.smartliu.domain.User;

import java.util.List;

public interface StudentMapper {
    User findById(int id);

    // 动态SQL。多条件，使用if标签
    public List<User> findByCondition(User user);
}
