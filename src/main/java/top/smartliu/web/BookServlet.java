package top.smartliu.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import top.smartliu.service.BookService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 方式一：写死配置名
        // ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 方式二：动态获取
        ServletContext servletContext = this.getServletContext();
        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        BookService bookService = (BookService) app.getBean("bookService");
        bookService.save();
    }
}
