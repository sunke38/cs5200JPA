package com.northeastern.cs5200.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.northeastern.cs5200.jpa.model.Course;
import com.northeastern.cs5200.jpa.model.Section;

public interface SectionRepository extends CrudRepository<Section, Integer>{

}
