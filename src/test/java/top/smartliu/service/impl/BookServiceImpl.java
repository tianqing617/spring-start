package top.smartliu.service.impl;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import top.smartliu.dao.BookDao;
import top.smartliu.service.BookService;

// <bean id="bookService" class="top.smartliu.service.impl.BookServiceImpl">
@Service("bookService")
@Scope("singleton")
public class BookServiceImpl implements BookService {
//    @Autowired
//    @Qualifier("bookDao")
    @Resource(name="bookDao") // 需引入 javax.annotation 坐标
    private BookDao bookDao;

    public BookServiceImpl() {}

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("book service save");
        bookDao.save();
    }
}
