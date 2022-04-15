package com.ty.foodapp.hungerfiller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodapp.hungerfiller.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
