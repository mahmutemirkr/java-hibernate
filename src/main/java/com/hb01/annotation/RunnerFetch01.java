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

        /*DB operations with HQL*/
        //HQL

        String hqlQuery = "FROM Student01";
        List<Student01> hqlResultList = session.createQuery(hqlQuery, Student01.class).getResultList();

        System.out.println("-HQL-");
        for (Student01 students : hqlResultList){

            System.out.println(students);

        }

        /*DB operations with SQL - uniqueResult*/
        //SQL

        String sqlQueryUnique = "SELECT * FROM e_student01 WHERE student_name='Brad Pitt'";
        Object[] uniqueResult = (Object[]) session.createSQLQuery(sqlQueryUnique).uniqueResult();
        System.out.println(Arrays.toString(uniqueResult));




        tx.commit();

        session.close();
        sf.openSession();


    }

}
