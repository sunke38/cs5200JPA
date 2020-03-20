package com.northeastern.cs5200.jpa;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.northeastern.cs5200.jpa.dao.UniversityDao;
import com.northeastern.cs5200.jpa.model.*;

@SpringBootTest
class Cs5200Spring2020KeSunJpaApplicationTests {
	@Autowired
	UniversityDao uDao;
	@Test
	void test() {
		uDao.truncateDatabase();
		
		Faculty alan = new Faculty("alan", "alan", "Alan", "Turin", "123A", true);
		Faculty ada = new Faculty("ada", "ada", "Ada", "Lovelace", "123B", true);
		
		Student alice = new Student("alice", "alice", "Alice", "Wonderland", 2020, 12000);
		Student bob = new Student("bob", "bob", "Bob", "Hope", 2021, 23000);
		Student charlie = new Student("charlie", "charlie", "Charlie", "Brown", 2019, 21000);
		Student dan = new Student("dan", "dan", "Dan", "Craig", 2019, 0);
		Student edward = new Student("edward", "edward", "Edward", "Scissorhans", 2021, 11000);
		Student frank = new Student("frank", "frank", "Frank", "Herbert", 2021, 0);
		Student gregory = new Student("gregory", "gregory", "Gregory", "Peck", 2021, 10000);
		
		Course cs1234 = new Course("CS1234", null);
		Course cs2345 = new Course("cs2345", null);
		Course cs3456 = new Course("cs3456", null);
		Course cs4567 = new Course("cs4567", null);
		
		Section sce4321 = new Section("sce4321",50,null);
		Section sce5432 = new Section("sce5432",50,null);
		Section sce6543 = new Section("sce6543",50,null);
		Section sce7654 = new Section("sce7654",50,null);
		
		uDao.createFaculty(alan);
		uDao.createFaculty(ada);
		
		uDao.createStudent(alice);
		uDao.createStudent(bob);
		uDao.createStudent(charlie);
		uDao.createStudent(dan);
		uDao.createStudent(edward);
		uDao.createStudent(frank);
		uDao.createStudent(gregory);
		
		uDao.createCourse(cs1234);
		uDao.createCourse(cs2345);
		uDao.createCourse(cs3456);
		uDao.createCourse(cs4567);
		
		uDao.setAuthorForCourse(alan, cs1234);
		uDao.setAuthorForCourse(alan, cs2345);
		uDao.setAuthorForCourse(ada, cs3456);
		uDao.setAuthorForCourse(ada, cs4567);
		
		uDao.addSectionToCourse(sce4321, cs1234);
		uDao.addSectionToCourse(sce5432, cs1234);
		uDao.addSectionToCourse(sce6543, cs2345);
		uDao.addSectionToCourse(sce7654, cs3456);
		
		uDao.enrollStudentInSection(alice, sce4321);
		uDao.enrollStudentInSection(alice, sce5432);
		uDao.enrollStudentInSection(bob, sce5432);
		uDao.enrollStudentInSection(charlie, sce6543);
		
		

		int userSize = uDao.findAllUsers().size();
		int studentSize = uDao.findAllStudent().size();
		int facultySize = uDao.findAllFaculty().size();
		int coursesSize = uDao.findAllCourses().size();
		int sectionSize = uDao.findAllSections().size();
		int alanCourse = uDao.findCoursesForAuthor(alan).size();
		int adaCourse =uDao.findCoursesForAuthor(ada).size();
		
		String sectionPerCourse ="";
		for(Course i : uDao.findAllCourses()) {
			List<Section> section = uDao.findSectionForCourse(i);
			sectionPerCourse += "Validates: "+ i.getLabel() + " have "+ section.size() +" sections\n";
		}
		
		String sectionEnrollments ="";
		for(Section i : uDao.findAllSections()) {
			List<Student> students = uDao.findStudentsInSection(i);
			sectionPerCourse += "Validates: "+ i.getTitle() + " have "+ students.size() +" students\n";
		}
		String studentEnrollments ="";
		for(Student i : uDao.findAllStudent()) {
			List<Section> section = uDao.findSectionsForStudent(i);
			sectionPerCourse += "Validates: "+ i.fullName() + " Joined "+ section.size() +" section\n";
		}
		String sectionSeat ="";
		for(Section i : uDao.findAllSections()) {
		
			sectionPerCourse += "Validates: "+ i.getTitle() + " remain "+ i.getSeats() +" seats\n";
		}
		System.out.println("\n\n");
		System.out.println("Validates: Total User is: "+userSize+" (Student: "+studentSize+" / Facluty: "+facultySize+")");
		System.out.println("Validates: Total Course is: "+sectionSize+" Total Sections: "+sectionSize);
		System.out.println("Validates: Alan have "+alanCourse+" Course");
		System.out.println("Validates: Ada have "+adaCourse+" Course");
		System.out.println(sectionPerCourse);
		System.out.println(sectionEnrollments);
		System.out.println(studentEnrollments);
		System.out.println(sectionPerCourse);
	}

}
