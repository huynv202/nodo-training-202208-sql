package com.example.spring_core.Unit1_SpringCore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean(name = "bean2")
    @Scope("singleton")
    public HelloClazz getHelloBean() {
        HelloClazz bean = new HelloClazz();
        bean.setMessage("Xin chao lop hoc Java");
        return bean;
    }

}
