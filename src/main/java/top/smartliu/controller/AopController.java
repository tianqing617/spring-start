package top.smartliu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.smartliu.aop.Target;
import top.smartliu.aop.TargetInterface;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AopController {
    // 类型声明为 TargetInterface 报错。原因：Target要实现TargetInterface接口，不然会注入失败。
    @Autowired
    private TargetInterface target;

    @RequestMapping("/test/aop")
    @ResponseBody
    public String testAop(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Controller aop running...");

        target.save();

        return "success.jsp";
    }
}
