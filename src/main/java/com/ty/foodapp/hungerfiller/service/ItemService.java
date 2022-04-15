package com.ty.foodapp.hungerfiller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.foodapp.hungerfiller.dao.ItemDao;
import com.ty.foodapp.hungerfiller.dto.Item;

@Service
public class ItemService {
	@Autowired
	private ItemDao itemDao;
	
	public Item saveItem(int id, Item item) {
		return itemDao.saveItem(id, item);
	}
	
	public Item getItemById(int id) {
		return itemDao.getItemById(id);
	}
	
	public List<Item> getAllItemsByFoodOrderId(int id){
		return itemDao.getAllByFoodOrderId(id);
	}
	
	public boolean deleteItemById(int id) {
		return itemDao.deleteItemById(id);
	}
}
