package top.smartliu.dao;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import top.smartliu.domain.Order;
import top.smartliu.domain.User;

import java.util.List;

public interface StudentMapper {
    User findById(int id);

    // 动态SQL。多条件，使用if标签
    public List<User> findByCondition(User user);

    // 动态SQL。多条件，使用foreach标签
    public List<User> findByIds(List<Integer> ids);

    public Order getOrderById(Integer id);

    public List<Order> getOrderAndUser();

    public List<User> findUserAndRoleAll();

    @Select("select * from students")
    @ResultMap("userMap")
    public List<User> findAll();
}
