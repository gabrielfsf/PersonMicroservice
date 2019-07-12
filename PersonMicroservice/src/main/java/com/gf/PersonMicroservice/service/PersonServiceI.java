package com.gf.PersonMicroservice.service;

import java.util.List;

import com.gf.PersonMicroservice.model.Person;

public interface PersonServiceI {

	public void save(Person person);
	public List<Person> findAll();
	public Person findById(Long id);
	
}
