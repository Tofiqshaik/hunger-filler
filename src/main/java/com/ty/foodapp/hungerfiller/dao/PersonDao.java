package com.ty.foodapp.hungerfiller.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodapp.hungerfiller.dto.Person;
import com.ty.foodapp.hungerfiller.repository.PersonRepository;

@Repository
public class PersonDao {
	@Autowired
	private PersonRepository personRepository;
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person getPersonByEmail(String email) {
		return personRepository.findByEmail(email);
	}
	
	public Person getPersonByPhone(long phone) {
		return personRepository.findByPhone(phone);
	}
}
