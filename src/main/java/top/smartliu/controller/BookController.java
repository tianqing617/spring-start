package top.smartliu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
