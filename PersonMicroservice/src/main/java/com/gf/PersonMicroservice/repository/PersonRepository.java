package com.gf.PersonMicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gf.PersonMicroservice.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	
	public Person findPersonById(Long id);
	public List<Person> findAll();
	

}
