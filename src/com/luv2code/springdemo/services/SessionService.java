package com.luv2code.springdemo.services;

import com.luv2code.springdemo.entity.Course;
import com.luv2code.springdemo.entity.Instructor;
import com.luv2code.springdemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionService {
    private final SessionFactory factory;
    private final Session session;

    public SessionService () {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        session = factory.getCurrentSession();
    }

    public void close () {
        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    public void beginTransaction () {
        session.beginTransaction();
    }

    public Instructor createInstructorWithDetails (String firstName, String lastName, String email, String youtubeChannel, String hobby) {
        var tempInstructor = new Instructor(firstName, lastName, email);
        var tempInstructorDetail = new InstructorDetail(youtubeChannel, hobby);

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        save(tempInstructor);

        return tempInstructor;
    }

    public InstructorDetail getInstructorDetailById (Integer id) {
        return session.get(InstructorDetail.class, id);
    }

    public Instructor getInstructorById (Integer id) {
        return session.get(Instructor.class, id);
    }

    public Course getCourseById (Integer id) {
        var course = session.get(Course.class, id);

        return course;
    }

    public void deleteInstructorById (Integer id) {
        var instructor = session.get(Instructor.class, id);

        if (instructor == null) {
            System.out.println("Instructor id " + id + " not found. Aborting deletion.");
            return;
        }

        session.delete(instructor);

        System.out.println("Instructor id " + id + " deleted successfully.");
    }

    public void deleteInstructorDetailById (Integer id) {
        var instructorDetail = session.get(InstructorDetail.class, id);

        if (instructorDetail == null) {
            System.out.println("Instructor Detail id " + id + " not found. Aborting deletion.");
            return;
        }

        var instructor = instructorDetail.getInstructor();
        instructor.setInstructorDetail(null);

        session.save(instructor);
        session.delete(instructorDetail);

        System.out.println("Instructor Detail id " + id + " deleted successfully.");
    }

    public Course createCourse (String title) {
        var course = new Course(title);
        save(course);

        return course;
    }

    public void save(Object o) {
        session.save(o);
    }
}
