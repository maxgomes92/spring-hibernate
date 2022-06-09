package com.luv2code.springdemo;

import com.luv2code.springdemo.services.SessionService;

public class CreateDemo {
    public static void main (String[] args) {
        var sessionService = new SessionService();

        try {
//            sessionService.createInstructorWithDetails("Max", "Gomes", "max@email.com", "/maxgomes92", "coding");
            var toDelete = sessionService.getInstructorById(1);
            toDelete.toString();

            sessionService.deleteInstructor(toDelete);
        } catch (Exception err) {
            System.out.println("Error!!! " + err.toString());
        } finally {
            sessionService.close();
        }
    }
}
