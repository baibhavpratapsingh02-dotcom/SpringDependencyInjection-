package com.example.config;

import com.example.model.Course;
import com.example.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Marks this class as a source of bean definitions
public class AppConfig {

    @Bean // Defines a bean named 'myCourse'
    public Course myCourse() {
        return new Course("Computer Science 101");
    }

    @Bean // Defines a bean named 'student' and automatically injects 'myCourse'
    public Student student() {
        // DI occurs here: the 'myCourse' bean is passed as the argument
        return new Student("Alice Johnson", myCourse()); 
    }
}
