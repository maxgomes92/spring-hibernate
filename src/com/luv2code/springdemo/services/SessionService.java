package com.luv2code.springdemo.services;

import com.luv2code.springdemo.entity.Instructor;
import com.luv2code.springdemo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionService {
    private SessionFactory factory;
    private Session session;

    public SessionService () {
        this.factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        this.session = factory.getCurrentSession();
    }

    public void close () {
        factory.close();
    }

    public Instructor createInstructorWithDetails (String firstName, String lastName, String email, String youtubeChannel, String hobby) {
        var tempInstructor = new Instructor(firstName, lastName, email);
        var tempInstructorDetail = new InstructorDetail(youtubeChannel, hobby);

        tempInstructor.setInstructorDetail(tempInstructorDetail);

        save(tempInstructor);

        return tempInstructor;
    }

    public Instructor getInstructorById (Integer id) {
        session.beginTransaction();
        var instructor = session.get(Instructor.class, id);
//        session.getTransaction().commit();

        return instructor;
    }

    public void deleteInstructor (Object o) {
//        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
    }

    private void save (Object o) {
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
    }
}
