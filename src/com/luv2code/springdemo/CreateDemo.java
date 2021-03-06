package com.luv2code.springdemo;

import com.luv2code.springdemo.services.SessionService;
import org.hibernate.internal.build.AllowSysOut;

public class CreateDemo {
    public static void main (String[] args) {
        var sessionService = new SessionService();
        sessionService.beginTransaction();

        try {
//            var instructorDetail = sessionService.getInstructorDetailById(4);
//            sessionService.createInstructorWithDetails("Max", "Gomes", "max@email.com", "/maxgomes92", "coding");
//            sessionService.deleteById(2);
//            sessionService.deleteInstructorDetailById(4);
//            var course = sessionService.createCourse("Truco");

//            Course
//            var course = sessionService.getCourseById(12);
//            var instructor = sessionService.getInstructorById(1);
//            instructor.add(course);
//            sessionService.save(instructor);

//            sessionService.deleteCourseById(10);
        } catch (Exception err) {
            System.out.println("Error!!! " + err);
        } finally {
            sessionService.close();
        }
    }
}
