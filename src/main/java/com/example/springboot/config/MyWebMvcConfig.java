package com.example.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author by LMGD
 * @date 2021-07-12 10:39
 * @description SpringMVC扩展
 * 1、添加 @Configuration 注解,就是把这个类放到容器里,交给Spring去管理
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    /**
     * 添加视图跳转(路由中转)
     *
     * @描述：也可以通过控制器写请求处理方法,推荐添加视图跳转
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //访问首页配置
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
    }

    /**
     * 添加拦截器
     *
     * @描述:可以配置哪些请求需要拦截(addPathPatterns)，那些请求可以放行(excludePathPatterns)
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截请求,放行请求配置
        registry.addInterceptor(new LoginHandelInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login", "/login.html", "/user/login", "/lib/**", "/static/**");
    }
}
