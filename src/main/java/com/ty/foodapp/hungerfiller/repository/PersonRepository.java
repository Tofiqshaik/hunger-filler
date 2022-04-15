package com.ty.foodapp.hungerfiller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodapp.hungerfiller.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{
	
	public Person findByEmail(String email);
	
	public Person findByPhone(long phone);
}
