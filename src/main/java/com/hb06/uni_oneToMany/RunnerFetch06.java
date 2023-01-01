package com.hb06.uni_oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student06 student = session.get(Student06.class,1001L);
        System.out.println("obj");
        System.out.println(student);
        System.out.println(student.getStudentNames());
        System.out.println(student.getGrade());
        System.out.println(student.getBookList());

        String hqlQuery1 = "FROM Book06 b WHERE b.id=101";
        Book06 book1 = session.createQuery(hqlQuery1, Book06.class).uniqueResult();
        System.out.println(book1);


        String hqlQuery2=
                "SELECT b.id, b.bookName FROM Student06 s INNER JOIN s.bookList b WHERE s.id=1001";
        List<Object[]> resultList1= session.createQuery(hqlQuery2).getResultList();
        System.out.println("HQL");
        resultList1.forEach(oa-> System.out.println(Arrays.toString(oa)));

        //101 -> Entity -> Book06 Class
        Book06 book06 = session.get(Book06.class,101L);
        System.out.println("--GET");
        System.out.println(book06.getBookName());

        tx.commit();
        session.close();
        sf.close();

    }
}
