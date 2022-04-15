package com.ty.foodapp.hungerfiller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodapp.hungerfiller.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
