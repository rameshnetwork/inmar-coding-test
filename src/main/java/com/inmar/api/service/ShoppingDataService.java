package com.inmar.api.service;

import java.util.List;

import com.inmar.api.dto.ShoppingDataDto;

public interface ShoppingDataService {
	public List<String> getLocations();

	public List<ShoppingDataDto> getDepartments(String location);

	public List<ShoppingDataDto> getCategories(String location, String department);

	public List<ShoppingDataDto> getSubcategory(String location, String department, String category);

	public List<ShoppingDataDto> getAll(String location, String department, String category, String subcategory);

	public ShoppingDataDto save(ShoppingDataDto shoppingDataDto);

	public void delete(ShoppingDataDto shoppingDataDto);
}
