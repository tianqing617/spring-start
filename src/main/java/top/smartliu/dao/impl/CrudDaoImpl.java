package top.smartliu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import top.smartliu.dao.CrudDao;
import top.smartliu.domain.User;

import java.util.List;

public class CrudDaoImpl implements CrudDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addDemo() {
        System.out.println("crud dao");
        // deleteDemo();

        // TODO: 删除未成功
        updateDemo();

        // selectAllDemo();

        // selectOneDemo();

        // countDemo();
    }

    // 删除示例
    public void deleteDemo() {
        jdbcTemplate.update("delete from students where id=?",5);
    }

    // 更新示例
    public void updateDemo() {
        jdbcTemplate.update("update students set id=? where age=?",3, 14);
    }

    // 查询所有
    public void selectAllDemo() {
        // TODO: BeanPropertyRowMapper 对象的作用
        List<User> userList = jdbcTemplate.query("select * from students", new BeanPropertyRowMapper<User>(User.class));
        System.out.println(userList);
    }

    // 查询单个
    public void selectOneDemo() {
        User user = jdbcTemplate.queryForObject("select * from students where id=?", new BeanPropertyRowMapper<User>(User.class), 3);
        System.out.println(user);
    }

    // 聚合查询
    public void countDemo() {
        Long count = jdbcTemplate.queryForObject("select count(*) from students", Long.class);
        System.out.println(count);
    }
}
