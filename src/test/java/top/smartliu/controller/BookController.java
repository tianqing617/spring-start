package top.smartliu.controller;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.smartliu.config.SpringConfig;
import top.smartliu.service.BookService;

public class BookController {
    @Test
    public void testBook() {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);

        BookService bookService = (BookService) app.getBean("bookService");
        bookService.save();
    }
}
