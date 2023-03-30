package top.smartliu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.smartliu.service.BookService;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) ctx.getBean("bookService");
        bookService.save();
    }
}

