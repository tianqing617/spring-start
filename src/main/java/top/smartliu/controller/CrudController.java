package top.smartliu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;
import top.smartliu.service.CrudService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@ContextConfiguration("classpath:applicationContext.xml")
public class CrudController {
    @Autowired
    private CrudService crudService;

    @RequestMapping("/crud/delete")
    public String deleteDemo() {
        System.out.println("deleteDemo");
        return "/success.jsp";
    }

    // 通过request获取app上下文对象
    @RequestMapping("/crud/add")
    public String addDemo(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ServletContext servletContext = session.getServletContext();

        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);

        CrudService crudService2 = (CrudService) app.getBean("crudService");
        crudService2.addDemo();

        return "/success.jsp";
    }

    // 通过自动注入，获取crudService
    @RequestMapping("/crud/add2")
    public String addDemo2() {
        crudService.addDemo();
        return "/success.jsp";
    }
}
