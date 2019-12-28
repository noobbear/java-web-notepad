package cn.fision.javawebnotepad.configuration;

import cn.fision.javawebnotepad.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: java-web-notepad
 * @description:
 * @author: Fision
 * @Email: fx@fision.cn
 * @create: 2019-12-28 13:11
 **/
@Configuration
public class MVCConfig implements WebMvcConfigurer {
    /**
     * 配置登录拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns( "/login",
                "/login.html", "/user/login","/css/**","/js/**","/img/**");
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // TODO Auto-generated method stub
/*        registry.addViewController("/").setViewName("index.html");
        registry.addViewController("/index").setViewName("index.html");
        registry.addViewController("/index.html").setViewName("index.html");*/
        registry.addViewController("/login").setViewName("login.html");
        registry.addViewController("/login.html").setViewName("login.html");

/*        registry.addViewController("/note/html/upload").setViewName("upload.html");
        registry.addViewController("/note/html/update").setViewName("update.html");*/
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    }
}
