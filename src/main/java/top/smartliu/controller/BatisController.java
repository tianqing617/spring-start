package top.smartliu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@ResponseBody
public class BatisController {
    @RequestMapping("/batis/test")
    public String test(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("test mybatis");

        return "success.jsp";
    }
}
