package com.northeastern.cs5200.jpa.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Faculty extends Person {
	private String office;
	private boolean tenured;
	@OneToMany(mappedBy="faculty",fetch = FetchType.EAGER)
	private List<Course> course;

	public Faculty() {
		super();
	}
	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param office
	 * @param tenured
	 */
	public Faculty(String username, String password, String firstName, String lastName, String office,boolean tenured) {
		super(username, password, firstName, lastName);
		this.office = office;
		this.tenured = tenured;
	}
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	public String getOffice() {
		return office;
	}
	public boolean isTenured() {
		return tenured;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public void setTenured(boolean tenured) {
		this.tenured = tenured;
	}
	@Override
	public String toString() {
		return "Faculty [getId()=" + getId() + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", office=" + office
				+ ", tenured=" + tenured + "]";
	}
	@Override
	public void print(){
		System.out.println(this.toString());
	}
	
}
