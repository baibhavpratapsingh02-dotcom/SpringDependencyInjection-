package com.example.app;

import com.example.config.AppConfig;
import com.example.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // 1. Load Spring context using the Java configuration class
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 2. Retrieve the configured Student bean
        Student student = context.getBean(Student.class);

        // 3. Use the bean to display details
        student.displayDetails();
    }
}
