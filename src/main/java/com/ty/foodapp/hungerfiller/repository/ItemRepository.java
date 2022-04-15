package com.ty.foodapp.hungerfiller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodapp.hungerfiller.dto.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
