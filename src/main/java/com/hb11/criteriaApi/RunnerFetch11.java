package com.hb11.criteriaApi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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


        //-----------------
        int sMathGrade=80;
        int lMathGrade=75;
        String hqlQuery3="UPDATE Student11 s SET s.mathGrade=:sMath where s.mathGrade<:lMath";
        Query query= session.createQuery(hqlQuery3);
        query.setParameter("sMath", sMathGrade);
        query.setParameter("lMath", lMathGrade);

        int numOfRec2= query.executeUpdate();
        System.out.println("Effected Row Count:"+ numOfRec2); //mathGrade<75, mathGrade fialds update = mathGrade=:80


        //CriteriaApi -****************************

        CriteriaBuilder cb= session.getCriteriaBuilder();
        CriteriaQuery<Student11> criteriaQuery= cb.createQuery(Student11.class);
        Root<Student11> root = criteriaQuery.from(Student11.class);
        criteriaQuery.select(root); //Select * FROM tableName
        Query<Student11> query1 = session.createQuery(criteriaQuery);
        List<Student11> resultLists= query1.getResultList();
        resultLists.forEach(s->System.out.println(s));

        //2-CriteriaApi
        criteriaQuery.select(root).where(cb.equal(root.get("name"),"Student Name 6"));
        Query<Student11> query2 = session.createQuery(criteriaQuery);
        List<Student11> resultList2= query2.getResultList();
        resultList2.forEach(System.out::println);

        //3-CriteriaApi -> greaterThan -> mathGrade>80
        criteriaQuery.select(root).where(cb.greaterThan(root.get("mathGrade"),80));
        Query<Student11> query3 = session.createQuery(criteriaQuery);
        List<Student11> resultList3= query3.getResultList();
        resultList3.forEach(System.out::println);

        //4-CriteriaApi -> lessThan -> mathGrade<95
        criteriaQuery.select(root).where(cb.lessThan(root.get("mathGrade"),95));
        Query<Student11> query4 = session.createQuery(criteriaQuery);
        List<Student11> resultList4= query4.getResultList();
        resultList4.forEach(System.out::println);



        tx.commit();
        session.close();
        sf.close();

    }
}
