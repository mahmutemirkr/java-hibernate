package com.hb06.uni_oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch06 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student06 student = session.get(Student06.class,1001L);
        System.out.println("obj");
        System.out.println(student);
        System.out.println(student.getStudentNames());
        System.out.println(student.getGrade());


        tx.commit();
        session.close();
        sf.close();

    }
}
