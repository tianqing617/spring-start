package top.smartliu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.smartliu.service.BatisService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@ResponseBody
public class BatisController {
    @Autowired
    private BatisService batisService;

    @RequestMapping("/batis/test")
    public String test(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("batis controller test");
        batisService.test();

        return "success.jsp";
    }
}
