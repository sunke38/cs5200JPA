package com.northeastern.cs5200.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.northeastern.cs5200.jpa.model.Course;
import com.northeastern.cs5200.jpa.model.Faculty;

public interface CourseRepository extends CrudRepository<Course, Integer>{

}
