package com.example.spring_core.Unit2_JDBC;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class JdbcApp {
    private static Logger LOGGER = Logger.getLogger(StudentJdbcDAO.class.getName());

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean_jdbc.xml");
        StudentJdbcDAO jdbc = (StudentJdbcDAO) context.getBean("studentJdbcDAO");
        LOGGER.info("create bean "+jdbc) ;
        List<Student>students= new ArrayList<>();
//        jdbc.insert("Huy", 20);
//        LOGGER.info("Total Student = " + jdbc.totalRecord());
//        students.add(new Student("ZZ", 20));
//        students.add(new Student("AA", 22));
//
//        int []values = jdbc.add(students);
//        for (int i =0;i<values.length;i++){
//            LOGGER.info("Inserted Record ID = " + (values[i]==0? "Fail":"Success"));
//        }
        jdbc.save("Huy", 20);
        LOGGER.info("Total Student = " + jdbc.totalRecord());


    }

}
