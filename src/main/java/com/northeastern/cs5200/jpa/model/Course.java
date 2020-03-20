package com.northeastern.cs5200.jpa.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String label;
	@ManyToOne
	private Faculty faculty;
	
	@OneToMany(mappedBy="course",fetch = FetchType.EAGER)
	private List<Section> section;
	
	
	public Course() {};
	/**
	 * @param id
	 * @param label
	 * @param faculty
	 * @param section
	 */
	public Course(String label, Faculty faculty) {
		this.label = label;
		this.faculty = faculty;
	}
	
	public int getId() {
		return id;
	}
	public String getLabel() {
		return label;
	}
	public Faculty getFaculty() {
		return faculty;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	public List<Section> getSection() {
		return section;
	}
	public void setSection(List<Section> section) {
		this.section = section;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", label=" + label + ", faculty=" + faculty.fullName() + ", section=" + section.size() + "]";
	}
	public void print(){
		System.out.println(this.toString());
	}
	
}
