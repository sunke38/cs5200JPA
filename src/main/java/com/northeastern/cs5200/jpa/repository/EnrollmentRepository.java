package com.northeastern.cs5200.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.northeastern.cs5200.jpa.model.Enrollment;
import com.northeastern.cs5200.jpa.model.Section;

public interface EnrollmentRepository  extends CrudRepository<Enrollment, Integer>{

}