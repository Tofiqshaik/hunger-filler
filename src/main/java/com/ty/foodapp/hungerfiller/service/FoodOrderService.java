package com.ty.foodapp.hungerfiller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.foodapp.hungerfiller.dao.FoodOrderDao;
import com.ty.foodapp.hungerfiller.dto.FoodOrder;
import com.ty.foodapp.hungerfiller.dto.Item;

@Service
public class FoodOrderService {
	@Autowired
	private FoodOrderDao foodOrderDao;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		List<Item> items = foodOrder.getItems();
		double cost =0;
		for (Item item : items) {
			cost += item.getCost()*item.getQuantity();
			item.setFoodOrder(foodOrder);
		}
		foodOrder.setTotal(cost*1.18);
		return foodOrderDao.saveFoodOrder(foodOrder);
	}
	
	public FoodOrder getFoodOrderById(int id) {
		return foodOrderDao.getFoodOrderById(id);
	}
	
	public List<FoodOrder> getAllFoodOrders(){
		return foodOrderDao.getAllFoodOrder();
	}
	
	public boolean deleteFoodOrderById(int id) {
		return foodOrderDao.deleteFoodOrderById(id);
	}
	
	public FoodOrder updateFoodOrderById(int id, FoodOrder foodOrder) {
		FoodOrder extFoodOrder = getFoodOrderById(id);
		if (extFoodOrder != null) {
			return foodOrderDao.updateFoodOrderById(foodOrder);
		}
		return null;
	}
	
	public FoodOrder updateStatus(int id, String status) {
		return foodOrderDao.updateStatus(id, status);
	}
}
