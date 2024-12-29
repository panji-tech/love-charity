package com.charity.config;

import com.charity.component.LoginHandlerInterceptor;
import com.charity.utils.PathUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC 配置
 * <p>

 *
 * 
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer, ErrorPageRegistrar {

    /**
     * 注册视图控制器
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 注册登录，忘记密码页面
        registry.addViewController("/login-page").setViewName("background/login");
        registry.addViewController("/register-page").setViewName("background/register");
        registry.addViewController("/forget-password").setViewName("background/forget-pwd");
        registry.addViewController("/password").setViewName("background/password");
        // 个人信息页面跳转
        registry.addViewController("/feedback").setViewName("front/feedback");
        // 注册错误页面
        registry.addViewController("/error400Page").setViewName("error/400");
        registry.addViewController("/error401Page").setViewName("error/401");
        registry.addViewController("/error404Page").setViewName("error/404");
        registry.addViewController("/error500Page").setViewName("error/500");
    }

    /**
     * 配置错误页面
     */
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error400Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/error400Page");
        ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error401Page");
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error404Page");
        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error500Page");
        registry.addErrorPages(error400Page, error401Page, error404Page, error500Page);
    }

    /**
     * 注册登录拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                // 拦截的请求
                .addPathPatterns("/**")
                // 不拦截的请求（放行）
                .excludePathPatterns(
                        "/", "/index", "/login-page", "/register-page",
                        "/login", "/register", "/sendCodeForRegister", "/updateUserPwd", "/sendCode",
                        "/articles", "/article", "/project", "/projects",
                        "/activity", "/activities", "/publishMessage", "/board", "/forget-password",
                        "/error400Page", "/error401Page", "/error404Page", "/error500Page",
                        "/**/front/**", "/asserts/**", "/**/*.css", "/**/*.js", "/**/*.png ",
                        "/**/*.jpg", "/**/*.jpeg", "/**/*.gif", "/**/fonts/*", "/**/*.svg");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = PathUtils.getClassLoadRootPath() + "/upload/";
        //第一个方法设置访问路径前缀，第二个方法设置资源路径
        registry.addResourceHandler("/upload/**").
                addResourceLocations("file:" + path);
    }
}
