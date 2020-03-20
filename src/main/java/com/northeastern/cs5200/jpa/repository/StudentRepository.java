package com.northeastern.cs5200.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.northeastern.cs5200.jpa.model.Section;
import com.northeastern.cs5200.jpa.model.Student;

public interface StudentRepository  extends CrudRepository<Student, Integer>{
	
}
