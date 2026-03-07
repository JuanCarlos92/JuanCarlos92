package com.juancarlos.curso.springboot.app.interceptor.springbootinterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Con la anotación @Configuration se indica que esta clase es una clase de configuración de Spring.
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    // Inyectamos el interceptor de tiempo de carga utilizando @Autowired y
    // @Qualifier para especificar el nombre del bean
    @Autowired
    @Qualifier("timeInterceptor")
    private HandlerInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor).addPathPatterns("/app/bar", "/app/foo");
        // registry.addInterceptor(timeInterceptor).excludePathPatterns("/app/bar");
    }

}
