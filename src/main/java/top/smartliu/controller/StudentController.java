package top.smartliu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.smartliu.service.BatisService;
import top.smartliu.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// MyBatis 代理开发方式示例
@Controller
@ResponseBody
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/student/test")
    public String test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("student controller test");
        studentService.test();

        return "success.jsp";
    }
}
