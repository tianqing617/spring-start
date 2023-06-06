package top.smartliu.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyInterceptor implements HandlerInterceptor {
    /**
     * 执行顺序：
     * preHandle
     * Controller save15 Interceptor
     * postHandle
     * afterCompletion
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        // 在目标方法执行之前 执行
        System.out.println("preHandle");
        //返回true代表放行  返回false代表不放行
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        // 在目标方法执行后，视图对象返回之前 执行
        System.out.println("postHandle");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 在流程都执行完毕后 执行
        System.out.println("afterCompletion");
    }
}
