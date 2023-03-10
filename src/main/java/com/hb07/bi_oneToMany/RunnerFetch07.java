package com.hb07.bi_oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {

    public static void main(String[] args) {


        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //get
        Student07 student =  session.get(Student07.class, 1001);
        student.getBookList().forEach(System.out::println);
        student.getBookList().forEach(b->System.out.println(b));


        //HQL
        String hqlQuery =
                "SELECT s.name,b.name FROM Student07 s INNER JOIN FETCH Book07 b ON s.id=b.student.id";
        List<Object[]> resultList2 = session.createQuery(hqlQuery).getResultList();
        resultList2.forEach(oa->System.out.println(Arrays.toString(oa)));


        tx.commit();
        session.close();
        sf.close();




    }


}
