package top.smartliu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.smartliu.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@Controller
public class BookController extends HttpServlet {
    @RequestMapping("/quick")
    public String save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Controller save running...");

        return "success.jsp";
    }
    @RequestMapping("/quick2")
    public String save2(String username, int age) throws IOException {
        // /quick2?username=jim&age=18
        System.out.println("save2" + username + age);

        return "success.jsp";
    }
    @RequestMapping("/quick3")
    public String save3(User user) throws IOException {
        // /quick3?username=jim&age=18
        System.out.println("save3" + user);

        return "success.jsp";
    }
}
