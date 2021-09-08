package com.patika.hw4.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomConfiguration implements WebMvcConfigurer {

    @Bean
    public dev.patika.patika0401.config.CustomInterceptor getInterceptor(){
        return new dev.patika.patika0401.config.CustomInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getInterceptor()).addPathPatterns("/**");
    }
}
