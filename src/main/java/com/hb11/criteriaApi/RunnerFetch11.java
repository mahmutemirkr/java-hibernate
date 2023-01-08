package com.hb11.criteriaApi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch11 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        //Update
        Student11 student = session.get(Student11.class, 1L);
        student.setName("Updated "+student.getName());
        session.update(student);


        tx.commit();
        session.close();
        sf.close();

    }
}
