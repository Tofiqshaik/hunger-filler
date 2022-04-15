package com.ty.foodapp.hungerfiller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodapp.hungerfiller.dto.Item;
import com.ty.foodapp.hungerfiller.service.ItemService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ItemController {
	@Autowired
	private ItemService itemService;

	@ApiOperation(value = " SAVE ITEM DETAILS BY ID", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "given ITEM data SAVED successFully By Id"),
			@ApiResponse(code = 405, message = "No given Id found") })

	@PostMapping("foodorder/{foodorder_id}/item")
	public Item saveItem(@PathVariable(name = "foodorder_id") int id, @RequestBody Item item) {
		return itemService.saveItem(id, item);
	}

	@ApiOperation(value = " DELETE PRODUCT DETAILS BY ID", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "given ITEM data GETByID successFully By Id"),
			@ApiResponse(code = 405, message = "No given Id found") })

	@GetMapping("/item")
	public Item getItemById(@RequestParam int id) {
		return itemService.getItemById(id);
	}

	@ApiOperation(value = "GET ALL ITEM DETAILS BY FOOD ORDERID", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "given ITEM data GET ALL  successFully ByFOOD ORDER Id"),
			@ApiResponse(code = 405, message = "No given Id found") })

	@GetMapping("/allitem")
	public List<Item> getAllItemsByFoodOrderId(@RequestParam int id) {
		return itemService.getAllItemsByFoodOrderId(id);
	}

	@ApiOperation(value = " DELETE ITEM  DETAILS BY ID", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "given ITEM data DELETED  successFully ByFOODORDER Id"),
			@ApiResponse(code = 405, message = "No given Id found") })

	@DeleteMapping("/item")
	public boolean deleteItemById(@RequestParam int id) {
		return itemService.deleteItemById(id);
	}
}
