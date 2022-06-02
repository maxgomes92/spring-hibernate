package com.luv2code.springdemo;

import com.luv2code.springdemo.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateApp {
    public static void main (String[] args) throws HibernateException {
        var factory = getFactory();
        var session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            // --- WORK
            runQuery(session,"from Student s where s.lastName='Walker'");
            // ---------

            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public static SessionFactory getFactory () {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    public static void runQuery(Session session, String query) {
        var result = session.createQuery(query).getResultList();
        System.out.println(result.toString());
        System.out.println((long) result.size());
    }

    public static void getUser (Session session) {
        var student = session.get(Student.class, 1);
        System.out.println(student.toString());
    }

    public static void createUser (Session session) {
        var student = new Student("Dida", "Walker", "dida@walker.com");
        session.save(student);
    }
}
