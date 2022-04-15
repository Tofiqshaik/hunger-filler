package com.ty.foodapp.hungerfiller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodapp.hungerfiller.dto.FoodOrder;
import com.ty.foodapp.hungerfiller.service.FoodOrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class FoodOrderController {
	@Autowired
	private FoodOrderService foodOrderService;

	@ApiOperation(value = " SAVE FOOD ORDER STATUS BY ID", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = " FOOD ORDER SAVED successFully By Id"),
			@ApiResponse(code = 405, message = "No given Id found") })

	@PostMapping("/foodorder")
	public FoodOrder saveFoodOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderService.saveFoodOrder(foodOrder);
	}

	@ApiOperation(value = " GET  FOOD ORDER  BY ID", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "given FOOD ORDER BY GET successFully By Id"),
			@ApiResponse(code = 405, message = "No given Id found") })

	@GetMapping("/foodorder")
	public FoodOrder getFoodOrderById(@RequestParam int id) {
		return foodOrderService.getFoodOrderById(id);
	}

	@ApiOperation(value = " GET ALL FOOD ORDER  BY ID", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "given FOOD ORDER ALL GET  successFully By Id"),
			@ApiResponse(code = 405, message = "No given Id found") })

	@GetMapping("/allfoodorder")
	public List<FoodOrder> getAllFoodOrders() {
		return foodOrderService.getAllFoodOrders();
	}

	@ApiOperation(value = " DELETED FOOD ORDER  BY ID", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "given FOOD ORDER  DELETED successFully By Id"),
			@ApiResponse(code = 405, message = "No given Id found") })

	@DeleteMapping("/foodorder")
	public boolean deleteFoodOrderById(@RequestParam int id) {
		return foodOrderService.deleteFoodOrderById(id);
	}

	@ApiOperation(value = " UPDATE FOOD ORDER  BY ID", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "given FOOD ORDER S UPDATED successFully By Id"),
			@ApiResponse(code = 405, message = "No given Id found") })

	@PutMapping("/foodorder")
	public FoodOrder updateFoodOrderById(@RequestParam int id, @RequestBody FoodOrder foodOrder) {
		return foodOrderService.updateFoodOrderById(id, foodOrder);
	}

	@ApiOperation(value = " UPDATE FOOD ORDER STATUS BY ID", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "given FOOD ORDER STATUS UPDATED successFully By Id"),
			@ApiResponse(code = 405, message = "No given Id found") })

	@PutMapping("/foodorder/status")
	public FoodOrder updateStatus(@RequestParam int id, @RequestParam String status) {
		return foodOrderService.updateStatus(id, status);
	}
}
