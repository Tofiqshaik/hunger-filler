package com.ty.foodapp.hungerfiller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.foodapp.hungerfiller.dao.PersonDao;
import com.ty.foodapp.hungerfiller.dto.Person;

@Service
public class PersonService {
	@Autowired
	private PersonDao personDao;
	
	public Person savePerson(Person person) {
		return personDao.savePerson(person);
	}
	
	public Person getPersonByEmail(String email) {
		return personDao.getPersonByEmail(email);
	}
	
	public Person getPersonByPhone(long phone) {
		return personDao.getPersonByPhone(phone);
	}
}
