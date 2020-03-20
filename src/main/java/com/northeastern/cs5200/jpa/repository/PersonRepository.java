package com.northeastern.cs5200.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.northeastern.cs5200.jpa.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer>{

}
