package cn.fision.javawebnotepad.interceptor;

import cn.fision.javawebnotepad.bean.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: java-web-notepad
 * @description:
 * @author: Fision
 * @Email: fx@fision.cn
 * @create: 2019-12-28 13:04
 **/
public class LoginInterceptor implements HandlerInterceptor  {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null ||user.getId()<=0) {
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        } else {
            return true;
        }
    }


}
