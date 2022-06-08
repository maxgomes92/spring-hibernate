package com.luv2code.springdemo.old;

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
            // runQuery(session,"from Student s where s.lastName='Walker'");
            // updateUser(session, 2);
            // runUpdate(session,"update Student set email='ju@celino.com' where firstName='Jucelino'");
            // runUpdate(session, "delete from Student where id=2");
            // deleteUser(session, 1);
            // ---------

            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public static void deleteUser (Session session, Integer id) {
        var user = getUser(session, id);
        session.delete(user);
    }

    public static void updateUser (Session session, Integer id) {
        var user = getUser(session, id);
        user.setFirstName("Jucelino");
    }

    public static SessionFactory getFactory () {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    public static void runUpdate (Session session, String query) {
        var result = session.createQuery(query).executeUpdate();
        System.out.println("Update result: " + result);
    }

    public static void runQuery(Session session, String query) {
        var result = session.createQuery(query).getResultList();
        System.out.println(result.toString());
    }

    public static Student getUser (Session session, Integer id) {
        var student = session.get(Student.class, id);
        System.out.println(student.toString());

        return student;
    }

    public static void createUser (Session session) {
        var student = new Student("Dida", "Walker", "dida@walker.com");
        session.save(student);
    }
}
