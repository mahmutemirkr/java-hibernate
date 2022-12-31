package com.hb04.bi_OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

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


        //Inner Join

        String hqlQuery = "SELECT s.name, d.name FROM Student04 s INNER JOIN FETCH Diary04 d on s.id=d.student";
        List<Object[]> resultList = Config.session.createQuery(hqlQuery).getResultList();
        for (Object[] objects:resultList) {

            System.out.println(Arrays.toString(objects));

        }

        System.out.println("Lambda");

        resultList.forEach(objects -> {
            System.out.println(Arrays.toString(objects));
        });


        //Left Join
        String hqlQueryLeftJoin= "SELECT s.name, d.name FROM Student04 s LEFT JOIN FETCH Diary04 d on s.id=d.student";
        List<Object[]> resultListLeftJoin = Config.session.createQuery(hqlQueryLeftJoin).getResultList();
        for (Object[] objects:resultListLeftJoin) {

            System.out.println(Arrays.toString(objects));

        }


        //Right Join
        String hqlQueryRightJoin = "SELECT s.name, d.name FROM Student04 s RIGHT JOIN FETCH Diary04 d on s.id=d.student";
        List<Object[]> resultListRightJoin = Config.session.createQuery(hqlQueryRightJoin).getResultList();
        for (Object[] objects:resultListRightJoin) {

            System.out.println(Arrays.toString(objects));

        }

        //FullJoin
        String hqlQuery4 =
                "SELECT s.name,d.name FROM Student04 s FULL JOIN FETCH Diary04 d on s.id=d.student.id";
        List<Object[]> resultList4 = Config.session.createQuery(hqlQuery4).getResultList();
        resultList4.forEach(oa->{
            System.out.println(Arrays.toString(oa));
        });







        Config.configureClose();


    }
}
