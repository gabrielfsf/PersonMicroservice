package com.gf.PersonMicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gf.PersonMicroservice.model.Person;
import com.gf.PersonMicroservice.service.PersonServiceImpl;

@RestController
@RequestMapping("/api")
public class PersonController {
	
	@Autowired
	PersonServiceImpl personServiceImpl;
	
	@GetMapping("/people")
	public List<Person> showAllPeople() {
		return personServiceImpl.findAll();
	}
	
	@GetMapping("/person")
	public Person findById(@RequestParam Long id) {
		return personServiceImpl.findById(id);
	}
	
	@PostMapping("/person/new")
	public String addNewPerson(Person person) {
		personServiceImpl.save(person);
		return "New Person Successfully Created";
	}
}
