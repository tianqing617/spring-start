package top.smartliu.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import top.smartliu.service.BookService;
import top.smartliu.service.CrudService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class CrudController {
    @RequestMapping("/crud/delete")
    public String deleteDemo() {
        System.out.println("deleteDemo");
        return "/success.jsp";
    }

    @RequestMapping("/crud/add")
    public String addDemo(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ServletContext servletContext = session.getServletContext();

        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        CrudService crudService = (CrudService) app.getBean("crudService");
        crudService.addDemo();

        return "/success.jsp";
    }
}
