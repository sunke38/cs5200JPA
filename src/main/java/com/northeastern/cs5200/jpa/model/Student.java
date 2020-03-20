package com.northeastern.cs5200.jpa.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Student extends Person {
	private int gradYear;
	private long scholarship;
	
	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(mappedBy="student",fetch = FetchType.EAGER)
	private List<Enrollment> enrollment;
	
	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param gradYear
	 * @param scholarship
	 */
	public Student() {
		super();
	}
	public Student(String username, String password, String firstName, String lastName, int gradYear,
			long scholarship) {
		super(username, password, firstName, lastName);
		this.gradYear = gradYear;
		this.scholarship = scholarship;
	}
	public int getGradYear() {
		return gradYear;
	}
	public long getScholarship() {
		return scholarship;
	}
	public void setGradYear(int gradYear) {
		this.gradYear = gradYear;
	}
	public void setScholarship(long scholarship) {
		this.scholarship = scholarship;
	}
	
	public List<Enrollment> getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(List<Enrollment> enrollment) {
		this.enrollment = enrollment;
	}
	
	@Override
	public String toString() {
		return "Student [getId()=" + getId() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", gradYear=" + gradYear
				+ ", scholarship=" + scholarship + "]";
	}
	@Override
	public void print(){
		System.out.println(this.toString());
	}
}
