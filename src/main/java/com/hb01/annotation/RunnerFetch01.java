package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch01 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        /*Database operations with Get Method*/
        //get()

        Student01 student01 = session.get(Student01.class,1000);
        Student01 student02 = session.get(Student01.class,1001);
        Student01 student03 = session.get(Student01.class,1002);

        System.out.println("Session Get");
        System.out.println(student01);
        System.out.println(student02);
        System.out.println(student03);



        tx.commit();

        session.close();
        sf.openSession();


    }

}
