package top.smartliu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.smartliu.service.BatisService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@ResponseBody
public class BatisController {
    @Autowired
    private BatisService batisService;

    @RequestMapping("/batis/test")
    public String test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("batis controller test");
        batisService.test();

        return "success.jsp";
    }

    // 一对一：查询一个订单，同时获取此订单对应的客户（实体内存在user字段，对应一个User对象）
    // 一对多：查询一个用户，購获取该用户所属的所有订单（实体内存在orderList字段，对应一组Order对象）
    // 多对多：查询用户的同时，查询出该用户的所有角色。
}
