package com.gf.PersonMicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gf.PersonMicroservice.model.Person;
import com.gf.PersonMicroservice.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonServiceI {

	@Autowired
	PersonRepository personRepository;

	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	public Person findById(Long id) {
		return personRepository.findPersonById(id);
	}

	@Override
	public void save(Person person) {
		personRepository.save(person);
	}

}
