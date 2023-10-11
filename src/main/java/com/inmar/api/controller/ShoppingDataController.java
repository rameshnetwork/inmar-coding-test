package com.inmar.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inmar.api.dto.ShoppingDataDto;
import com.inmar.api.service.ShoppingDataService;

@RestController
public class ShoppingDataController {

	@Autowired
	private ShoppingDataService shoppingDataService;

	@GetMapping("/api/v1/location")
	public ResponseEntity<List<String>> getLocations() {
		return new ResponseEntity<>(shoppingDataService.getLocations(), HttpStatus.OK);
	}

	@GetMapping("/api/v1/location/{location_id}/department")
	public ResponseEntity<List<ShoppingDataDto>> getDepartmentByLocation(@PathVariable("location_id") String location) {
		return new ResponseEntity<>(shoppingDataService.getDepartments(location), HttpStatus.OK);
	}

	@GetMapping("/api/v1/location/{location_id}/department/{department_id}/category")
	public ResponseEntity<List<ShoppingDataDto>> getCategoryByLocationAndDepartment(@PathVariable("location_id") String location,
			@PathVariable("department_id") String department) {
		return new ResponseEntity<>(shoppingDataService.getCategories(location, department), HttpStatus.OK);
	}

	@GetMapping("/api/v1/location/{location_id}/department/{department_id}/category/{category_id}/subcategory")
	public ResponseEntity<List<ShoppingDataDto>> getsubcategoryByLocationAndDepartmentAndCategory(
			@PathVariable("location_id") String location, @PathVariable("department_id") String department,
			@PathVariable("category_id") String category) {
		return new ResponseEntity<>(shoppingDataService.getSubcategory(location, department, category), HttpStatus.OK);
	}

	@GetMapping("/api/v1/location/{location_id}/department/{department_id}/category/{category_id}/subcategory/{subCategory_id}")
	public ResponseEntity<List<ShoppingDataDto>> getSubCategory(@PathVariable("location_id") String location,
			@PathVariable("department_id") String department, @PathVariable("category_id") String category,
			@PathVariable("subCategory_id") String subcategory) {
		return new ResponseEntity<>(shoppingDataService.getAll(location, department, category, subcategory), HttpStatus.OK);
	}

	@PostMapping("/api/v1/save")
	public ResponseEntity<ShoppingDataDto> saveDetails(@RequestBody ShoppingDataDto shoppingDataDto) {
		return new ResponseEntity<>(shoppingDataService.save(shoppingDataDto), HttpStatus.OK);
	}

	@PostMapping("/api/v1/delete")
	public ResponseEntity<String> deleteDetails(@RequestBody ShoppingDataDto shoppingDataDto) {
		shoppingDataService.delete(shoppingDataDto);
		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}
}