package com.gf.PersonMicroservice;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.gf.PersonMicroservice.model.Person;
import com.gf.PersonMicroservice.repository.PersonRepository;
import com.gf.PersonMicroservice.service.PersonServiceI;
import com.gf.PersonMicroservice.service.PersonServiceImpl;

@RunWith(SpringRunner.class)
public class PersonServiceTest {
	
	private static Person person1;
	private static List<Person> listOfPeople;
	
	@TestConfiguration
    static class PeopleServiceTestContextConfiguration {
  
        @Bean
        public PersonServiceI configuration() {
            return new PersonServiceImpl();
        }
    }
	
	@Autowired
    private PersonServiceI personService;
 
    @MockBean
    private PersonRepository personRepository;
    
    @Before
    public void setUp() {
		person1 = new Person("Bill", 25);
		listOfPeople = new ArrayList<>(Arrays.asList(person1));
		Mockito.when(personRepository.findAll()).thenReturn(listOfPeople);
    }
 

	@Test
	public void givenPerson_whenFindAll_thenReturnListOfPeople() {
		List<Person> found = personService.findAll();
		assertEquals(listOfPeople, found);
	}
	
	
	
	
	

}

