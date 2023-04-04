package top.smartliu.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.smartliu.service.BookService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        BookService bookService = (BookService) app.getBean("bookService");
        bookService.save();
    }
}
