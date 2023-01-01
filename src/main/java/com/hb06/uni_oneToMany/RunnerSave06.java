package com.hb06.uni_oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerSave06 {

    public static void main(String[] args) {

        Book06 book1 = new Book06();
        book1.setId(101L);
        book1.setBookName("Art Book");

        Book06 book2 = new Book06();
        book2.setId(102L);
        book2.setBookName("Math Book");

        Book06 book3 = new Book06();
        book3.setId(103L);
        book3.setBookName("Java Book");

        Book06 book4 = new Book06();
        book3.setId(104L);
        book3.setBookName("English Book");



        Student06 student1 = new Student06();
        student1.setId(1001L);
        student1.setStudentNames("Cedric");
        student1.setGrade(75);
        student1.getBookList().add(book1);

        Student06 student2 = new Student06();
        student2.setId(1002L);
        student2.setStudentNames("Chen");
        student2.setGrade(75);
        student2.getBookList().add(book2);

        Student06 student3 = new Student06();
        student3.setId(1003L);
        student3.setStudentNames("Nicolas");
        student3.setGrade(75);
        student3.getBookList().add(book3);

        Student06 student4 = new Student06();
        student4.setId(1004L);
        student4.setStudentNames("Jendiri");
        student4.setBookList(104L,"Math Book");



        Configuration con = new Configuration().configure("hibernate.cfg.xml").
               addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);

        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);


        tx.commit();
        session.close();
        sf.close();


    }
}
