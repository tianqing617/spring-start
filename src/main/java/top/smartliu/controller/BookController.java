//获取请求参数示例
package top.smartliu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.smartliu.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class BookController {
    @RequestMapping("/quick")
    public String save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Controller save running...");
        // response.getWriter().print("hello itcast");

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
    @RequestMapping("/quick4")
    public String save4(String[] username) throws IOException {
        // /quick4?username=jim&username=lucy
        System.out.println("save4" + Arrays.asList(username));

        return "success.jsp";
    }
    @RequestMapping(value="/quick5", method = RequestMethod.POST)
    @ResponseBody  // 告知SpringMVC框架 不进行视图跳转 直接进行数据响应
    public void save5(@RequestBody List<User> userList) throws IOException {
        // /quick5
        System.out.println("save5" + userList);

        // return "success.jsp";
    }

    @RequestMapping(value="/quick6")
    public String save6(@RequestBody User user) throws IOException {
        // /quick6
        System.out.println("save6" + user);

        return "success.jsp";
    }
}
