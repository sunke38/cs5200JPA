package com.northeastern.cs5200.jpa.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Section {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int seats;
	private String title;
	@ManyToOne
	private Course course;
	@OneToMany(mappedBy="section",fetch = FetchType.EAGER)
	private List<Enrollment> enrollment;
	
	
	/**
	 * @param id
	 * @param seats
	 * @param course
	 */
	public Section() {}
	public Section(String title,int seats, Course course) {
		this.title=title;
		this.seats = seats;
		this.course = course;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Enrollment> getEnrollment() {
		return enrollment;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setEnrollment(List<Enrollment> enrollment) {
		this.enrollment = enrollment;
	}
	public int getId() {
		return id;
	}
	public int getSeats() {
		return seats;
	}
	public Course getCourse() {
		return course;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Section [id=" + id + ", seats=" + seats + ", course=" + course + "]";
	}
	public void print(){
		System.out.println(this.toString());
	}	
}
