package com.example.spring_core.Unit1_SpringCore;


import com.example.spring_core.SpringCoreApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;


public class App {
    private final static Logger LOGGER =Logger.getLogger(String.valueOf(HelloWorld.class));
    public static void main(String[] args) {
        SpringApplication.run(SpringCoreApplication.class, args);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        HelloClazz obj = (HelloClazz)context.getBean("helloJavaClazz");
//        obj.printMessage();
//
//        HelloClazz obj2 = (HelloClazz) context.getBean("helloJavaClazz");
//        obj2.printMessage();
//        System.out.println(obj2==obj2);
//
//        context.registerShutdownHook();
//
//       HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
//         helloWorld.sayHello();

        JavaClazz clazz = (JavaClazz) context.getBean("jee01");
        LOGGER.info("Map Implement is "+clazz.getStudents().getClass());
        LOGGER.info("There are "+clazz.getStudents().size()+" in the class");
    }

}
