package com.example.dao;

import com.example.model.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class StudentDAO {

    private final SessionFactory factory;

    public StudentDAO() {
        // Load configuration and create SessionFactory
        this.factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }
    
    // 1. CREATE
    public void saveStudent(StudentEntity student) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            System.out.println("C: Saved student: " + student.getName());
        }
    }
    
    // 2. READ (by ID)
    public StudentEntity getStudent(int id) {
        try (Session session = factory.openSession()) {
            return session.get(StudentEntity.class, id);
        }
    }

    // 2. READ (all)
    public List<StudentEntity> getAllStudents() {
        try (Session session = factory.openSession()) {
            return session.createQuery("from StudentEntity", StudentEntity.class).list();
        }
    }

    // 3. UPDATE
    public void updateStudent(StudentEntity student) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
            System.out.println("U: Updated student: " + student.getId());
        }
    }

    // 4. DELETE
    public void deleteStudent(int id) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            StudentEntity student = session.get(StudentEntity.class, id);
            if (student != null) {
                session.delete(student);
                System.out.println("D: Deleted student ID: " + id);
            }
            session.getTransaction().commit();
        }
    }
}
