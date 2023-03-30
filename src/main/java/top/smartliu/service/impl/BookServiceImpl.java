package top.smartliu.service.impl;

import top.smartliu.dao.BookDao;
import top.smartliu.service.BookService;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    public  BookServiceImpl() {}
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("book service save");
        bookDao.save();
    }
}
