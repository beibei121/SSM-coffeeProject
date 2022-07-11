package org.ccunix.coffee.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLoginInterceptor implements HandlerInterceptor {
    /**
     * 在拦截资源前执行的方法  如果该方法返回false 那么不会执行你要访问的控制器
     * 登录成功后需要在session中存储一个adminLoginUser的内容为用户登录信息
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        if (session.getAttribute("adminLoginUser")==null){
            //没有进行登录的正确验证
            System.out.println("没有进行登录的正确验证,请前往登录页面进行验证");
            response.sendRedirect(request.getContextPath()+"/toAdminLogin");
            return false;
        }
        return true;
    }
}
