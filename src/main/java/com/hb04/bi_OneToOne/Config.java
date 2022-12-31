package com.hb04.bi_OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Config {

    static SessionFactory sessionFactory;
    static Session session;
    static Transaction transaction;

    public static void configureStart(){

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        sessionFactory = con.buildSessionFactory();

        session = sessionFactory.openSession();

        transaction = session.beginTransaction();

    }

    public static void configureClose(){

        transaction.commit();
        session.close();
        sessionFactory.close();
    }


}
