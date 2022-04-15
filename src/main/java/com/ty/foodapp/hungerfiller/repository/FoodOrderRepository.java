package com.ty.foodapp.hungerfiller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodapp.hungerfiller.dto.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer>{

}
