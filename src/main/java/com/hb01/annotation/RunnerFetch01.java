package com.hb01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

        /*DB operations with SQL*/
        //SQL

        String sqlQuery = "SELECT * FROM e_student01";
        List<Objects[]> resultList = session.createSQLQuery(sqlQuery).getResultList();

        System.out.println("-SQL-");
        for (Object[] objects : resultList){

            System.out.println(Arrays.toString(objects));

        }



        tx.commit();

        session.close();
        sf.openSession();


    }

}
