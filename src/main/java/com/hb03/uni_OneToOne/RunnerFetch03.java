package com.hb03.uni_OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch03 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student03 student = session.get(Student03.class,1001);

        Diary diary = session.get(Diary.class,101);

        System.out.println("--Student");

        System.out.println(student);

        System.out.println("--Diary");

        System.out.println(diary);

        System.out.println("--Diary GetStudent");

        System.out.println(diary.getStudent());


        tx.commit();
        session.close();
        sf.close();


    }


}