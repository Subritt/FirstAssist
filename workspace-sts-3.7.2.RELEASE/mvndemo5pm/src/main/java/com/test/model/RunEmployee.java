package com.test.model;

import java.util.Arrays;

import javax.persistence.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunEmployee {
	
	public static void main(String[] args) {
		
		//oneToOne();
		//oneToMany();
		ManyToMany();
		
	}
	
	//one to one
	static void oneToOne(){
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Address adr = new Address();
		adr.setCountry("Nepal");
		adr.setCity("Ktm");
		adr.setState("State3");
		adr.setZip("977");
		
		session.save(adr);
		
		Employee emp = new Employee() ;
		emp.setFname("carlos");
		emp.setLname("Young");
		emp.setSalary(900000);
		emp.setAddress(adr);
		
		session.save(emp);
		session.getTransaction().commit();
		session.close();
		
	}
	
	//one to many
	static void oneToMany(){
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Address adr = new Address();
		adr.setCountry("Nepal");
		adr.setCity("Ktm");
		adr.setState("State3");
		adr.setZip("977");
		
		session.save(adr);
		
		Employee emp = new Employee() ;
		emp.setFname("carlos");
		emp.setLname("Young");
		emp.setSalary(900000);
		emp.setAddress(adr);
		
		PhoneNumber p1 = new PhoneNumber();
		p1.setNumber("1234567");
		p1.setEmployee(emp);
		
		session.save(p1);
		
		PhoneNumber p2 = new PhoneNumber();
		p2.setNumber("0987654");
		p2.setEmployee(emp);
		
		session.save(p2);
		
		
		emp.setPhoneList(Arrays.asList(p1,p2));
		
		session.save(emp);
		session.getTransaction().commit();
		session.close();
		
	}
	
	//many to many
	static void ManyToMany(){
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Address adr = new Address();
		adr.setCountry("Nepal");
		adr.setCity("Ktm");
		adr.setState("State3");
		adr.setZip("977");
		
		session.save(adr);
		
		Employee emp = new Employee() ;
		emp.setFname("carlos");
		emp.setLname("Young");
		emp.setSalary(900000);
		emp.setAddress(adr);
		
		PhoneNumber p1 = new PhoneNumber();
		p1.setNumber("1234567");
		p1.setEmployee(emp);
		
		session.save(p1);
		
		PhoneNumber p2 = new PhoneNumber();
		p2.setNumber("0987654");
		p2.setEmployee(emp);
		
		session.save(p2);
		
		Department d1 = new Department();
		d1.setName("IT");
		session.save(d1) ;
		
		Department d2 = new Department();
		d2.setName("Admin");
		session.save(d2);
		
		emp.setDlist(Arrays.asList(d1,d2));
		emp.setPhoneList(Arrays.asList(p1,p2));
		
		session.save(emp);
		session.getTransaction().commit();
		session.close();

		
	}

}
