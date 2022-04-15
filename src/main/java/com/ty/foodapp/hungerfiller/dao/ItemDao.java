package com.ty.foodapp.hungerfiller.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodapp.hungerfiller.dto.FoodOrder;
import com.ty.foodapp.hungerfiller.dto.Item;
import com.ty.foodapp.hungerfiller.repository.ItemRepository;

@Repository
public class ItemDao {
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	FoodOrderDao foodOrderDao;
	
	public Item saveItem(int id, Item item) {
		FoodOrder foodOrder = foodOrderDao.getFoodOrderById(id);
		if (foodOrder != null) {
			item.setFoodOrder(foodOrder);
			return itemRepository.save(item);
		}
		return null;
	}
	
	public Item getItemById(int id) {
		Optional<Item> optional = itemRepository.findById(id);
		if (optional != null) {
			return optional.get();
		}
		return null;
	}
	
	public List<Item> getAllByFoodOrderId(int id){
		FoodOrder foodOrder = foodOrderDao.getFoodOrderById(id);
		if (foodOrder != null) {
			return itemRepository.findAll();
		}
		return null;
	}
	
	public boolean deleteItemById(int id) {
		Item item = getItemById(id);
		if (item != null) {
			itemRepository.delete(item);
			return true;
		}
		return false;
	}
}
