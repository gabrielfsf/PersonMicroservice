package com.gf.MicroserviceUser.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MicroserviceUserController {

	@GetMapping("/")
	public void index(){
	       RestTemplate restTemplate = new RestTemplate();
	       Map<?,?> quote = restTemplate.getForObject("http://localhost:8080/api/person?id=1", HashMap.class);
	       System.out.println(quote.get("name"));
	    }
}
