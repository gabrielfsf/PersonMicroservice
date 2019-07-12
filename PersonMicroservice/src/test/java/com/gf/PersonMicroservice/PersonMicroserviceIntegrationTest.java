package com.gf.PersonMicroservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.gf.PersonMicroservice.model.Person;
import com.gf.PersonMicroservice.repository.PersonRepository;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = PersonMicroserviceApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class PersonMicroserviceIntegrationTest {
	
	private Person person1;
	
	@Autowired
    private PersonRepository personRepository;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void givenId_findPersonById_returnsJsonAnd200Status() throws Exception {
		person1 = new Person("Bill", 25);
		personRepository.save(person1);
		
		mvc.perform(get("/api/people")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content()
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	
}
