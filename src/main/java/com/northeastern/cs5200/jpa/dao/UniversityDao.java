package com.northeastern.cs5200.jpa.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.northeastern.cs5200.jpa.model.*;
import com.northeastern.cs5200.jpa.repository.*;

@Repository
public class UniversityDao {
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	PersonRepository personRepository;
	@Autowired
	FacultyRepository facultyRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	SectionRepository sectionRepository;
	@Autowired
	EnrollmentRepository enrollmentRepository;

	public void truncateDatabase() {
		enrollmentRepository.deleteAll();
		sectionRepository.deleteAll();
		courseRepository.deleteAll();
		personRepository.deleteAll();
	}
	public void createStudent(Student student){
		studentRepository.save(student);
	}
	public void createFaculty(Faculty faculty){
		facultyRepository.save(faculty);
	}
	public void createCourse(Course course){
		courseRepository.save(course);
	}
	public void createSection(Section section){
		sectionRepository.save(section);	
	}
	public void addSectionToCourse(Section section,Course course){
		section.setCourse(course);
		sectionRepository.save(section);
	}
	public void setAuthorForCourse(Faculty faculty,Course course){
		course.setFaculty(faculty);
		courseRepository.save(course);
	}
	public Boolean enrollStudentInSection(Student student,Section Section) {
		Section section = sectionRepository.findById(Section.getId()).get();
		if(section.getSeats()<=0) {
			return false;
		}
		section.setSeats(section.getSeats()-1);
		sectionRepository.save(section);
		Enrollment eroll = new Enrollment();
		eroll.setSection(section);
		eroll.setStudent(student);
		enrollmentRepository.save(eroll);
		return true;
	}
	public List<Person> findAllUsers(){
		List<Person> person = new ArrayList<>();
		for(Person i : personRepository.findAll())
			person.add(i);
		return person;
	}
	public List<Faculty> findAllFaculty(){
		List<Faculty> faculty = new ArrayList<>();
		for(Faculty i : facultyRepository.findAll())
			faculty.add(i);
		return faculty;
	}
	public List<Student> findAllStudent(){
		List<Student> student = new ArrayList<>();
		for(Student i : studentRepository.findAll())
			student.add(i);
		return student;
	}
	public List<Course> findAllCourses(){
		List<Course> course = new ArrayList<>();
		for(Course i : courseRepository.findAll())
			course.add(i);
		return course;
	}
	public List<Section> findAllSections(){
		List<Section> section = new ArrayList<>();
		for(Section i : sectionRepository.findAll())
			section.add(i);
		return section;
	}
	public List<Course> findCoursesForAuthor(Faculty faculty){
		return facultyRepository.findById(faculty.getId()).get().getCourse();
	}
	public List<Section> findSectionForCourse(Course course){
		return courseRepository.findById(course.getId()).get().getSection();
	}
	public List<Student> findStudentsInSection(Section section){
		List<Enrollment> enroll = sectionRepository.findById(section.getId()).get().getEnrollment();
		List<Student> student = new ArrayList<>();
		for(Enrollment i :enroll)
			student.add(i.getStudent());
		return student;
	}
	public List<Section> findSectionsForStudent(Student student){
		List<Enrollment> enroll = studentRepository.findById(student.getId()).get().getEnrollment();
		List<Section> section = new ArrayList<>();
		for(Enrollment i :enroll)
			section.add(i.getSection());
		return section;
	}
}
