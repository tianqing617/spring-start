package top.smartliu.dao.impl;

import org.springframework.stereotype.Repository;
import top.smartliu.dao.BookDao;

// <bean id="bookDao" class="top.smartliu.dao.impl.BookDaoImpl"/>
@Repository("bookDao")
public class BookDaoImpl implements BookDao {
    public void save() {
        System.out.println("book dao save ...");
    }
}
