package com.luv2code.springdemo;

import com.luv2code.springdemo.entity.Instructor;
import com.luv2code.springdemo.entity.InstructorDetail;
import com.luv2code.springdemo.entity.Student;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main (String[] args) {
        var factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        try {
            var session = factory.getCurrentSession();

            var tempInstructor = new Instructor("Chad", "Darby", "darby@email.com");
            var tempInstructorDetail = new InstructorDetail("https://youtube.com/darby", "coding");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();
            session.save(tempInstructor);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}
