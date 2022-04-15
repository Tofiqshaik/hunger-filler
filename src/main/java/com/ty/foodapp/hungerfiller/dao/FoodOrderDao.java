package com.ty.foodapp.hungerfiller.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodapp.hungerfiller.dto.FoodOrder;
import com.ty.foodapp.hungerfiller.dto.Item;
import com.ty.foodapp.hungerfiller.repository.FoodOrderRepository;

@Repository
public class FoodOrderDao {
	@Autowired
	private FoodOrderRepository foodOrderRepository;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepository.save(foodOrder);
	}
	
	public FoodOrder getFoodOrderById(int id) {
		Optional<FoodOrder> optional = foodOrderRepository.findById(id);
		if (optional != null) {
			return optional.get();
		}
		return null;
	}
	
	public List<FoodOrder> getAllFoodOrder(){
		return foodOrderRepository.findAll();
	}
	
	public boolean deleteFoodOrderById(int id) {
		FoodOrder foodOrder = getFoodOrderById(id);
		if (foodOrder != null) {
			foodOrderRepository.delete(foodOrder);
			return true;
		}
		return false;  
	}
	
	public FoodOrder updateFoodOrderById(FoodOrder foodOrder) {
		return foodOrderRepository.save(foodOrder);
	}
	
	public FoodOrder updateStatus(int id, String status) {
		FoodOrder foodOrder = getFoodOrderById(id);
		if (foodOrder != null) {
			foodOrder.setStatus(status);
			return foodOrderRepository.save(foodOrder);
		}
		return foodOrder;
	}
}
