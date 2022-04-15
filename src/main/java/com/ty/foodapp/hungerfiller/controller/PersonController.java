package com.ty.foodapp.hungerfiller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodapp.hungerfiller.dto.Person;
import com.ty.foodapp.hungerfiller.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@PostMapping("/person")
	public Person savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}
	
	@GetMapping("/person/email")
	public Person getPersonByEmail(@RequestParam String email) {
		return personService.getPersonByEmail(email);
	}
	
	@GetMapping("/person/phone")
	public Person getPersonByPhone(@RequestParam long phone) {
		return personService.getPersonByPhone(phone);
	}
}
