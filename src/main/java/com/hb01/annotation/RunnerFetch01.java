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
        System.out.println("Unique SQL");
        System.out.println(Arrays.toString(uniqueResult));


        /*DB operations with HQL - uniqueResult*/
        //HQL

        String hqlQueryUnique = "FROM Student01 WHERE name='Tom Hanks'";
        Student01 uniqueResultHql = session.createQuery(hqlQueryUnique, Student01.class).uniqueResult();
        System.out.println("Unique HQL");
        System.out.println(uniqueResultHql);


        /*DB operations with HQL - uniqueResult*/
        //HQL - Alias Def.

        String hqlQueryAlias = "FROM Student01 std WHERE std.name='Johnny Depp'";
        Student01 uniqueResultAlias = session.createQuery(hqlQueryAlias, Student01.class).uniqueResult();
        System.out.println("Alias with HQL");
        System.out.println(uniqueResultAlias);

        /*DB operations with HQL - uniqueResult*/
        //HQL - Alias Def. | Just name and ıd pull data -> where -> grade => 85

        String hqlQueryAlias1 = "SELECT s.id, s.name FROM Student01 s WHERE s.grade=85";
        List<Object[]> resultListUni = session.createQuery(hqlQueryAlias1).getResultList();
        System.out.println("2-Alias with HQL");
        for (Object[] objects:resultListUni){
            System.out.println(Arrays.toString(objects));
        }


        tx.commit();

        session.close();
        sf.openSession();


    }

}
