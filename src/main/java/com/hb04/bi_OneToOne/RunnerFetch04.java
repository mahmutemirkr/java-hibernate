package com.hb04.bi_OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch04 {

    public static void main(String[] args) {

        Config.configureStart();

        //ID - 1001 -> GET

        Student04 student1 = Config.session.get(Student04.class,1001);
        System.out.println("--Student");
        System.out.println(student1);
        Diary04 diary = Config.session.get(Diary04.class, 101);
        System.out.println("--Diary");
        System.out.println(diary);
        System.out.println("BiDirectional - getDiary");
        System.out.println(student1.getDiary());
        System.out.println("BiDirectional - getStudent");
        System.out.println(diary.getStudent());




        Config.configureClose();


    }
}
