package com.charity.component;

import com.charity.constant.RoleStatus;
import com.charity.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 登录拦截器
 * <p>

 *
 * 
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    /**
     * 在目标方式执行之前执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        String[] array = new String[]{
                "/publishActivity", "/updateActivity", "/deleteActivity", "/deleteBoard", "/checkCertification",
                "/deleteFeedBack", "/deleteLink", "/addLink", "/publishProject",
                "/updateProject", "/deleteProject", "/listUsers", "/editUser", "/admin-user",
                "/admin-certification", "/new-activity", "/edit-activity", "/admin-activity", "/new-project",
                "/admin-project", "/edit-project", "/admin-link", "/admin-feedback", "/admin-board",
                "/admin-project-comment", "/admin-activity-comment", "/admin-article", "/preview"
        };
        List<String> adminPath = new ArrayList<>(Arrays.asList(array));
        User user = (User) request.getSession().getAttribute("loginUser");
        if (user == null) {
            //未登录,返回登录页面
            response.sendRedirect("/love-charity/login-page");
            return false;
        } else {
            // 如果是普通用户
            if (user.getRole() == RoleStatus.USER) {
                // 访问管理员路径
                if (adminPath.contains(path)) {
                    response.sendRedirect("/love-charity/error401Page");
                    return false;
                }
            }
            // 已登录，放行
            return true;
        }
    }
}
