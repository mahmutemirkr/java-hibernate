package com.hb11.criteriaApi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RunnerFetch11 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        //Update
        Student11 student = session.get(Student11.class, 1L);
        student.setName("Updated "+student.getName());
        session.update(student);


        //Update -HQL
    	String hqlQuery1=
				"UPDATE Student11 s SET s.name='Updated with HQL' where s.id=11";
		int numOfRec=session.createQuery(hqlQuery1).executeUpdate();
		System.out.println("Effected Row Count:"+ numOfRec);

		String hqlQuery2="FROM Student11 s WHERE s.mathGrade<50";
		List<Student11> resultList=
				session.createQuery(hqlQuery2,Student11.class).getResultList();

		for (Student11 studentX : resultList) {
			student.setMathGrade(50);
			session.update(studentX);
		}


        tx.commit();
        session.close();
        sf.close();

    }
}
