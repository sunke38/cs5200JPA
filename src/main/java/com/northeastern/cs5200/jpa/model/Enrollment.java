package com.northeastern.cs5200.jpa.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Enrollment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int grade;
	private String feedback;
	@ManyToOne
	private Student student;
	@ManyToOne
	private Section section;
	public Enrollment() {}
	/**
	 * @param id
	 * @param grade
	 * @param feedback
	 * @param student
	 * @param section
	 */
	public Enrollment(int grade, String feedback, Student student, Section section) {
		super();
		this.grade = grade;
		this.feedback = feedback;
		this.student = student;
		this.section = section;
	}
	public int getId() {
		return id;
	}
	public int getGrade() {
		return grade;
	}
	public String getFeedback() {
		return feedback;
	}
	public Student getStudent() {
		return student;
	}
	public Section getSection() {
		return section;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	@Override
	public String toString() {
		return "Enrollment [id=" + id + ", grade=" + grade + ", feedback=" + feedback + ", student=" + student.getFirstName() + " " + student.getLastName()
				+ ", section=" + section.getId() + "]";
	}

	public void print(){
		System.out.println(this.toString());
	}
	
}
