//获取请求参数示例
package top.smartliu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.smartliu.domain.User;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.File;
import java.util.Arrays;
import java.util.Date;
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
    public String save5(@RequestBody List<User> userList) throws IOException {
        /*  请求参数
            curl --location 'http://localhost:8080/spring_start_war_exploded/quick5' \
            --header 'Content-Type: application/json' \
            --header 'Cookie: JSESSIONID=044EB97173FE4A231631E59EA95367CD' \
            --data '[
                {
                    "username": "zs",
                    "age": 18
                },
                {
                    "username": "ls",
                    "age": 20
                }
            ]'
         */
        System.out.println("save5" + userList);

        return "success.jsp";
    }

    // POST请求报415错误，解决方案：https://blog.csdn.net/Mr_FenKuan/article/details/108935680
    @RequestMapping(value="/quick6", method = RequestMethod.POST)
    public String save6(@RequestBody User user) throws IOException {
        /* 请求参数
        * curl --location 'http://localhost:8080/spring_start_war_exploded/quick6' \
            --header 'Content-Type: application/json' \
            --header 'Cookie: JSESSIONID=044EB97173FE4A231631E59EA95367CD' \
            --data '{"username":"天青","age":18}'
        * */
        System.out.println("save6" + user);

        return "success.jsp";
    }

    // requestParam示例
    @RequestMapping("/quick7")
    public String save7(@RequestParam("name") String username) throws IOException {
        // /quick7?username=jim
        System.out.println("save7" + username);

        return "success.jsp";
    }

    // Restful示例
    // 报404错误。解决方案：增加@ResponseBody注释
    // @ResponseBody 告知SpringMVC框架 不进行视图跳转 直接进行数据响应。否则会跳转到/spring_start_war_exploded/quick8/success.jsp，报404
    @RequestMapping("/quick8/{name}")
    @ResponseBody
    public String save8(@PathVariable(value = "name", required = true) String name) throws IOException {
        // /quick8/jim
        System.out.println("save8" + name);

        return "success.jsp";
    }

    @RequestMapping("/quick9")
    public String save9(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        // /quick9
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);

        return "success.jsp";
    }

    @RequestMapping("/quick10")
    public String save10(@RequestHeader(value = "User-Agent", required = false) String userAgent) throws IOException {
        // /quick10
        System.out.println("save10 " + userAgent);

        return "success.jsp";
    }
    @RequestMapping("/quick11")
    public String save11(@CookieValue(value = "JSESSIONID") String jsessionId) throws IOException {
        // /quick10
        System.out.println("save11 " + jsessionId);

        return "success.jsp";
    }

    // 日期类型转换器
    @RequestMapping(value="/quick12")
    public String save12(Date date) throws IOException {
        System.out.println("save12 " + date);

        return "success.jsp";
    }

    // 上传文件
    @RequestMapping(value="/quick13")
    public String save13(String username, MultipartFile uploadFile) throws IOException {
        /**
         curl --location 'http://localhost:8080/spring_start_war_exploded/quick13' \
         --header 'Cookie: JSESSIONID=B57450AB1F45E9777F8BADFB16BF0FC3' \
         --form 'username="lucy2"' \
         --form 'uploadFile=@"/Users/tianqing/Desktop/imgs/bean.png"'
         */
        System.out.println(username);
        //获得上传文件的名称
        String originalFilename = uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("/Users/tianqing/study/temp/" + originalFilename));

        return "success.jsp";
    }

    @RequestMapping(value="/quick14")
    public String save14(String username, MultipartFile[] uploadFile) throws IOException {
        /**
         curl --location 'http://localhost:8080/spring_start_war_exploded/quick14' \
         --header 'Cookie: JSESSIONID=928741745D68D156D56CB6171275AB26' \
         --form 'username="lucy2"' \
         --form 'uploadFile=@"/Users/tianqing/Desktop/imgs/ipad.png"' \
         --form 'uploadFile=@"/Users/tianqing/Desktop/imgs/iphone6s.png"'
         */
        System.out.println(username);
        for (MultipartFile multipartFile : uploadFile) {
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("/Users/tianqing/study/temp/" + originalFilename));
        }

        return "success.jsp";
    }
}
