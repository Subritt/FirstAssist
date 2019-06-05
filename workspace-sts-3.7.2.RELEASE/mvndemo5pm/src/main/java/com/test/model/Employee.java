package com.test.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String fname;
	@Column
	private String lname;
	@Column
	private long salary;
	
	//one to one
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address ;
	
	//one to many
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	private List<PhoneNumber> phoneList;
	
	//many to many
	@ManyToMany
	@JoinTable (name = "emp_dept" , joinColumns = {@JoinColumn (name = "emp_id")}, inverseJoinColumns = {@JoinColumn (name = "dept_id")} ) 
			private List<Department> dlist ;
	
	
	public List<Department> getDlist() {
		return dlist;
	}

	public void setDlist(List<Department> dlist) {
		this.dlist = dlist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<PhoneNumber> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<PhoneNumber> phoneList) {
		this.phoneList = phoneList;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
