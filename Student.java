package com.example.model;

public class Student {
    private String studentName;
    private Course course; // Dependency

    // Dependency Injection via Constructor
    public Student(String studentName, Course course) {
        this.studentName = studentName;
        this.course = course;
    }

    public void displayDetails() {
        System.out.println("Student Name: " + studentName);
        System.out.println(course.getCourseInfo()); // Use the injected dependency
    }
}
