package com.test.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunStudent {
	
	public static void main(String[] args) {
		
		//add();
		//getALl();
		update();
		//delete();
		
	}
	
	//create Student
	static void add(){
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Student s = new Student();
		s.setFname("Cable");
		s.setLname("");
		s.setAddress("Marvel");
		
		session.save(s) ;
		session.getTransaction().commit();
		session.close();
		
	}
	
	//select all from Student
	static void getALl(){
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();		
		
		Criteria crt = session.createCriteria(Student.class);
		List<Student> slist = crt.list() ;
		
		for(Student s : slist){
			
			System.out.println(s);
			
		}
		
	}
	
	//Update
	static void update(){
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Student s = (Student)session.get(Student.class, 2);
		
		s.setAddress("DC");
		s.setFname("Slayde");
		s.setLname("Wilson");
		
		session.update(s);//update sql
		session.getTransaction().commit();
		session.close();
		
	}
	
	//Delete
	static void delete(){
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Student s = (Student)session.get(Student.class, 1);
		
//		s.setAddress("DC");
//		s.setLname("Slayde");
		
		session.delete(s);//delete sql
		session.getTransaction().commit();
		session.close();
		
	}

}
